package com.mytest.jvm;

import java.util.*;

public class HelloGC {
    public static void main(String[] args) {
        System.out.println("HelloGC");
        List list = new LinkedList();
        for(;;){
            byte[] b = new byte[1024*1025];
            list.add(b);
        }
    }
}
