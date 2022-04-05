package com.mysqltest.file;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        File f = new File("/Users/sunql/Documents/test.txt");
        System.out.println(File.separator);
        System.out.println(f.canRead()?"可读":"不可读");
        System.out.println(f.canWrite()?"可写":"不可写");
        System.out.println(f.canExecute()?"可执行":"不可执行");
        System.out.println(f.getName());
        System.out.println(f.getParent());
        System.out.println(f.getParentFile());
        System.out.println("***********路径相关方法***************");
        System.out.println("绝对路径"+f.getAbsolutePath());
        System.out.println("相对路径"+f.getPath());
        System.out.println("TOSTRING:"+f.toString());
    }
}
