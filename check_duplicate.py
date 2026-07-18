#!/usr/bin/env python3
"""检查GitHub Issue是否重复"""
import json, urllib.request, ssl, sys

TOKEN = "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"
REPO = sys.argv[1] if len(sys.argv) > 1 else "hjj-forge/ulab"
KEYWORD = sys.argv[2] if len(sys.argv) > 2 else ""

ctx = ssl._create_unverified_context()
h = {"Authorization": f"Bearer {TOKEN}", "Accept": "application/vnd.github+json", "User-Agent": "ULab-Manager"}

req = urllib.request.Request(f"https://api.github.com/repos/{REPO}/issues?state=all&per_page=100", headers=h)
with urllib.request.urlopen(req, timeout=15, context=ctx) as r:
    issues = json.loads(r.read().decode())

bugs = [i for i in issues if 'pull_request' not in i]

if KEYWORD:
    # Search by keyword
    kw = KEYWORD.lower()
    matches = [i for i in bugs if kw in i['title'].lower()]
    print(f"搜索 '{KEYWORD}' 在 {REPO}:")
    if matches:
        for i in matches:
            labels = [l['name'] for l in i.get('labels', [])]
            print(f"  #{i['number']} [{i['state']}] {i['title']} labels={labels}")
            print(f"    {i['html_url']}")
    else:
        print(f"  未找到匹配的Issue")
else:
    # Show all open issues
    open_bugs = [i for i in bugs if i['state'] == 'open']
    print(f"{REPO} 共 {len(bugs)} 个Issue，其中 {len(open_bugs)} 个Open:")
    for i in open_bugs:
        labels = [l['name'] for l in i.get('labels', [])]
        print(f"  #{i['number']} {i['title'][:80]} labels={labels}")
