#!/bin/bash
cd "$(dirname "$0")"
echo "启动 ULab Manager..."
python3 rebuild.py
echo ""
python3 server.py
