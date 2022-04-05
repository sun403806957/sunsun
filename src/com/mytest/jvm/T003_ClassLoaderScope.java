package com.mytest.jvm;

public class T003_ClassLoaderScope {
    public static void main(String[] args) {
        String pathBoot = System.getProperty("sun.boot.class.path");
       System.out.println(pathBoot);
        String pathExt = System.getProperty("java.ext.dirs");
        System.out.println(pathExt);
        String pathApp = System.getProperty("java.class.path");
       System.out.println(pathApp);
    }
}
