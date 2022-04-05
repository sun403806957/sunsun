package com.mysqltest.file;

import java.io.File;
import java.io.FileReader;

public class FileIn {
    public static void main(String[] args) throws Exception{
        //文件--》程序
        //有一个文件
        //FileReader这个流
        File filein = new File("/Users/sunql/Documents/test.txt");
        System.out.println("按照字符流一个字符一个字符读取");
        FileReader fileReader = new FileReader(filein);
        /*
        int n = fileReader.read();
        while (n!=-1){
            System.out.println(n);
            n = fileReader.read();
        }
         */
        /* 按照一个字符一个字符读取方法二
        int n ;
        while ((n = fileReader.read())!= -1){
            System.out.println((char)n);
         }
        */
        System.out.println("*****************");
        System.out.println("五个字节一读取");
        char [] a = new char[5];
        int m =fileReader.read(a);
        while(m!=-1){
            String str = new String(a,0,m);
            System.out.println(str);
            m = fileReader.read(a);
        }
        fileReader.close();
    }
}
