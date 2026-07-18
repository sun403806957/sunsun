#!/usr/bin/env python3
"""ULab Manager - Bug和测试用例管理服务器"""
import http.server
import json
import os
import socket
import ssl
import sys
import urllib.request

PORT = 8765
DIR = os.path.dirname(os.path.abspath(__file__))
DATA_DIR = os.path.join(DIR, 'data')
STATIC_DIR = os.path.join(DIR, 'static')

# GitHub Token: 从 ~/.github_token 文件读取，或从环境变量 GITHUB_TOKEN 读取
def _get_token():
    token_file = os.path.expanduser('~/.github_token')
    if os.path.exists(token_file):
        with open(token_file, 'r') as f:
            return f.read().strip()
    return os.environ.get('GITHUB_TOKEN', '')

GITHUB_TOKEN = _get_token()
GITHUB_REPO = "sun403806957/sunsun"
GITHUB_ISSUES_API = f"https://api.github.com/repos/{GITHUB_REPO}/issues?state=all&per_page=100"
# New bugs go to ULab-specific repo
GITHUB_BUG_REPO = "hjj-forge/ulab"

class Handler(http.server.SimpleHTTPRequestHandler):
    def __init__(self, *args, **kwargs):
        super().__init__(*args, directory=STATIC_DIR, **kwargs)

    def do_GET(self):
        if self.path == '/api/bugs':
            self.handle_bugs()
        elif self.path == '/api/github-issues':
            self.handle_github_issues()
        elif self.path == '/api/test-cases':
            filepath = os.path.join(DATA_DIR, 'test-cases.md')
            try:
                with open(filepath, 'r', encoding='utf-8') as f:
                    content = f.read()
                self.send_json({'ok': True, 'content': content})
            except FileNotFoundError:
                self.send_json({'ok': True, 'content': '# ULab-I期 测试用例\n\n'})
        else:
            super().do_GET()

    def handle_github_issues(self):
        """Fetch issues from GitHub API and return as JSON"""
        try:
            ctx = ssl._create_unverified_context()
            req = urllib.request.Request(GITHUB_ISSUES_API)
            req.add_header("Authorization", f"Bearer {GITHUB_TOKEN}")
            req.add_header("Accept", "application/vnd.github+json")
            req.add_header("User-Agent", "ULab-Manager")
            with urllib.request.urlopen(req, timeout=15, context=ctx) as resp:
                issues = json.loads(resp.read().decode())
            # Simplify issues to relevant fields
            result = []
            for issue in issues:
                # Skip pull requests (GitHub API returns PRs as issues too)
                if 'pull_request' in issue:
                    continue
                labels = [l['name'] for l in issue.get('labels', [])]
                result.append({
                    'number': issue['number'],
                    'title': issue['title'],
                    'body': issue.get('body', ''),
                    'state': issue['state'],
                    'labels': labels,
                    'html_url': issue['html_url'],
                    'created_at': issue['created_at'],
                    'updated_at': issue['updated_at'],
                    'user': issue.get('user', {}).get('login', ''),
                })
            self.send_json({'ok': True, 'issues': result})
        except Exception as e:
            self.send_json({'ok': False, 'message': str(e)}, 500)

    def handle_bugs(self):
        """Return bugs from GitHub Issues (same as /api/github-issues but compatible format)"""
        self.handle_github_issues()

    def do_POST(self):
        if self.path == '/api/bugs':
            length = int(self.headers.get('Content-Length', 0))
            data = json.loads(self.rfile.read(length))
            self.handle_create_issue(data)
        else:
            self.send_json({'ok': False, 'message': 'unknown'}, 404)

    def handle_create_issue(self, data):
        """Create a GitHub Issue for a bug"""
        try:
            title = data.get('title', 'Untitled Bug')
            body = data.get('body', '')
            labels = data.get('labels', ['bug'])
            issue_data = json.dumps({
                'title': title,
                'body': body,
                'labels': labels
            }).encode('utf-8')
            ctx = ssl._create_unverified_context()
            req = urllib.request.Request(
                f"https://api.github.com/repos/{GITHUB_BUG_REPO}/issues",
                data=issue_data,
                method='POST'
            )
            req.add_header("Authorization", f"Bearer {GITHUB_TOKEN}")
            req.add_header("Accept", "application/vnd.github+json")
            req.add_header("User-Agent", "ULab-Manager")
            req.add_header("Content-Type", "application/json")
            with urllib.request.urlopen(req, timeout=15, context=ctx) as resp:
                issue = json.loads(resp.read().decode())
            self.send_json({
                'ok': True,
                'issue': {
                    'number': issue['number'],
                    'html_url': issue['html_url']
                }
            })
            print(f'  ✅ Issue #{issue["number"]} created: {title}')
        except Exception as e:
            self.send_json({'ok': False, 'message': str(e)}, 500)

    def send_json(self, data, code=200):
        self.send_response(code)
        self.send_header('Content-Type', 'application/json; charset=utf-8')
        self.send_header('Access-Control-Allow-Origin', '*')
        self.end_headers()
        self.wfile.write(json.dumps(data, ensure_ascii=False).encode('utf-8'))

    def do_OPTIONS(self):
        self.send_response(200)
        self.send_header('Access-Control-Allow-Origin', '*')
        self.send_header('Access-Control-Allow-Methods', 'GET, POST, OPTIONS')
        self.send_header('Access-Control-Allow-Headers', 'Content-Type')
        self.end_headers()

    def log_message(self, format, *args):
        print(f'  [{self.command}] {args[0]}')

def get_local_ip():
    try:
        s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
        s.connect(('8.8.8.8', 80))
        ip = s.getsockname()[0]
        s.close()
        return ip
    except:
        return '127.0.0.1'

if __name__ == '__main__':
    ip = get_local_ip()
    print(f'''
╔══════════════════════════════════════════════╗
║        ULab Manager - Bug & 测试用例管理       ║
║                                              ║
║  本机:  http://localhost:{PORT}               ║
║  局域网: http://{ip}:{PORT}        ║
║                                              ║
║  Bug数据: GitHub Issues (实时同步)            ║
║  测试用例: data/test-cases.md                ║
║                                              ║
║  重建HTML: python3 rebuild.py                ║
║  按 Ctrl+C 停止                               ║
╚══════════════════════════════════════════════╝
''')
    server = http.server.HTTPServer(('0.0.0.0', PORT), Handler)
    try:
        server.serve_forever()
    except KeyboardInterrupt:
        print('\n服务器已停止')
        server.server_close()
