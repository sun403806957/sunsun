package com.mysqltest.file;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Fileinout {
    public static void main(String[] args) throws Exception {
        File file = new File("/Users/sunql/Documents/test.txt");
        File file2 = new File("/Users/sunql/Documents/test1.txt");
        FileReader fr = new FileReader(file);
        FileWriter fw = new FileWriter(file2);
        //方法一个字节一个字节写入
        /*
        int n = fr.read();
        while (n != -1){
            fw.write(n);
            System.out.println(n);
            n = fr.read();
        }
         */
        //方法二利用字符数组缓冲
        /*
        char[]  a = new char[5];
        int m = fr.read(a);
        while (m != -1){
            fw.write(a,0,m);
            m =  fr.read(a);
        }

         */
        //方法三 利用字符数组转换为字符串
        char[]  a = new char[5];
        int m = fr.read(a);
        while(m != -1){
            String s = new String(a,0,m);
            fw.write(s);
            m = fr.read(a);
        }
        fw.close();
        fr.close();
    }
}
