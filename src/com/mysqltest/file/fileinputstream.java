package com.mysqltest.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class fileinputstream {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/sunql/Documents/test.jpg");
        File file2 = new File("/Users/sunql/Documents/test1.jpg");
        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream outputStream = new FileOutputStream(file2);
        byte[] a =new byte [89];
        int len = inputStream.read(a);
        while(len != -1){
           outputStream.write(a);
           len = inputStream.read(a);
        }
        inputStream.close();
        outputStream.close();

    }
}
