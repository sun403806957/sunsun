#!/usr/bin/env python3
"""ULab Manager - Bug和测试用例管理服务器"""
import http.server
import json
import os
import socket
import sys

PORT = 8765
DIR = os.path.dirname(os.path.abspath(__file__))
DATA_DIR = os.path.join(DIR, 'data')
STATIC_DIR = os.path.join(DIR, 'static')

class Handler(http.server.SimpleHTTPRequestHandler):
    def __init__(self, *args, **kwargs):
        super().__init__(*args, directory=STATIC_DIR, **kwargs)

    def do_GET(self):
        if self.path == '/api/bugs':
            filepath = os.path.join(DATA_DIR, 'bugs.md')
            try:
                with open(filepath, 'r', encoding='utf-8') as f:
                    content = f.read()
                self.send_json({'ok': True, 'content': content})
            except FileNotFoundError:
                self.send_json({'ok': True, 'content': '# ULab-I期 Bug 记录\n\n'})
        elif self.path == '/api/test-cases':
            filepath = os.path.join(DATA_DIR, 'test-cases.md')
            try:
                with open(filepath, 'r', encoding='utf-8') as f:
                    content = f.read()
                self.send_json({'ok': True, 'content': content})
            except FileNotFoundError:
                self.send_json({'ok': False, 'message': 'not found'})
        else:
            super().do_GET()

    def do_POST(self):
        if self.path == '/api/save-bugs':
            length = int(self.headers.get('Content-Length', 0))
            data = json.loads(self.rfile.read(length))
            filepath = os.path.join(DATA_DIR, 'bugs.md')
            with open(filepath, 'w', encoding='utf-8') as f:
                f.write(data.get('content', ''))
            self.send_json({'ok': True, 'message': 'bugs.md saved'})
        else:
            self.send_json({'ok': False, 'message': 'unknown'}, 404)

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
║  数据文件: data/test-cases.md                ║
║           data/bugs.md                       ║
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
