package com.mysqltest.file;

import java.io.File;
import java.io.FileWriter;
import java.io.StringReader;

public class FileOut {
    public static void main(String[] args) throws Exception{
        File fileOut = new File("/Users/sunql/Documents/test1.txt");
        FileWriter fw = new FileWriter(fileOut,true);
        String abc = "helloworld2";
        /*一个字符一个字符写文件
        for (int i =0 ;i <abc.length();i ++){
            fw.write(abc.charAt(i));
        }
         */
        //五个字符一起写入
        fw.write(abc);
        fw.close();
    }
}
