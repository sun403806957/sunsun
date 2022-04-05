package com.mysqltest.file;

import java.io.*;

public class filebuffer {
    public static void main(String[] args) throws Exception{
        //测试定义缓冲的字节数组大于89
        File f1 = new File("/Users/sunql/Documents/test.jpg");
        File f2 = new File("/Users/sunql/Documents/test1.jpg");
        FileInputStream fis = new FileInputStream(f1);
        FileOutputStream fow = new FileOutputStream(f2);
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fow);
        byte[] b = new byte[10];
        int len = bis.read(b);
        while (len !=-1){
            bos.write(b,0,len);
            len = bis.read(b);
        }
        bis.close();
        bos.close();
    }
}
