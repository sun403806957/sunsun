# ULab Manager - Bug & 测试用例管理

基于 Markdown 文件的 Bug 和测试用例管理系统。

## 项目结构

```
ulab-manager/
├── server.py          # HTTP 服务器
├── rebuild.py         # 重建 HTML（嵌入最新数据）
├── start.sh           # 一键启动
├── data/
│   ├── test-cases.md  # 测试用例定义
│   └── bugs.md        # Bug 记录
└── static/
    └── index.html     # 查看器（自包含）
```

## 快速开始

```bash
cd ulab-manager
bash start.sh
```

浏览器打开 `http://localhost:8765`

## 使用方式

### 查看模式
- 浏览测试用例（按教师/学生模块分组）
- 左侧目录导航

### 执行模式
- 点击「✅ 执行」切换
- 勾选用例执行状态
- 标记结果（通过/失败/阻塞/跳过）
- 记录 Bug（严重程度、状态、附件）

### 保存数据
- Bug 自动保存到 `data/bugs.md`
- 执行状态保存在浏览器 localStorage
- 定期导出 JSON 备份

### 发布到钉钉
1. 运行 `python3 rebuild.py` 重建 HTML
2. 将 `static/index.html` 上传到钉钉作为附件
3. 团队成员下载打开即可查看最新数据

## API

| 接口 | 方法 | 说明 |
|------|------|------|
| `/api/test-cases` | GET | 获取测试用例 |
| `/api/bugs` | GET | 获取 Bug 列表 |
| `/api/save-bugs` | POST | 保存 Bug 数据 |
