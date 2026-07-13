#!/usr/bin/env python3
"""重建 static/index.html，嵌入最新的 data/test-cases.md 和 data/bugs.md"""
import os

DIR = os.path.dirname(os.path.abspath(__file__))
DATA_DIR = os.path.join(DIR, 'data')
HTML_PATH = os.path.join(DIR, 'static', 'index.html')

def escape_tl(s):
    return s.replace('\\', '\\\\').replace('`', '\\`').replace('${', '\\${')

# Read data files
with open(os.path.join(DATA_DIR, 'test-cases.md'), 'r', encoding='utf-8') as f:
    tc_md = f.read()
with open(os.path.join(DATA_DIR, 'bugs.md'), 'r', encoding='utf-8') as f:
    bugs_md = f.read()

# Read HTML
with open(HTML_PATH, 'r', encoding='utf-8') as f:
    html = f.read()

# Replace embedded data
tc_marker = 'var EMBED_TC = `'
bugs_marker = 'var EMBED_BUGS = `'

for marker, data in [(tc_marker, tc_md), (bugs_marker, bugs_md)]:
    start = html.find(marker)
    if start >= 0:
        start += len(marker)
        end = html.find('`;', start)
        if end >= 0:
            html = html[:start] + escape_tl(data) + html[end:]

with open(HTML_PATH, 'w', encoding='utf-8') as f:
    f.write(html)

tc_count = sum(1 for l in tc_md.split('\n') if l.strip().startswith('| TC-'))
bug_count = bugs_md.count('## BUG-')

print(f'✅ HTML 已重建')
print(f'   测试用例: {tc_count} 条')
print(f'   Bug记录:  {bug_count} 个')
print(f'   文件:     {HTML_PATH}')
print(f'')
print(f'现在可以部署到服务器或上传到钉钉')
