package com.mysqltest.file;

import java.io.File;

public class dir {
    public static void main(String[] args)throws Exception {
        File f = new File("/Users/sunql/Documents/c/f/e/text.txt");
        System.out.println(f.createNewFile());
        System.out.println(f.getAbsolutePath());

    }
}
