package com.mysqltest.file;

import java.io.*;

public class streamreader {
    public static void main(String[] args) throws Exception{
        File f1 = new File("/Users/sunql/Documents/test.txt");
        FileInputStream fis = new FileInputStream(f1);
        InputStreamReader isr = new InputStreamReader(fis);
        char[] ch = new char[10];
        int len = isr.read(ch);
        while (len != -1){
            System.out.println(new String(ch,0,len));
            len = isr.read(ch);
        }
        fis.close();
    }
}
