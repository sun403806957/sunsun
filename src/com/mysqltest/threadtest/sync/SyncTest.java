package com.mysqltest.threadtest.sync;

import javax.xml.namespace.QName;

public class SyncTest implements Runnable{
    private volatile int count ;
    public /*synchronized*/ void run(){
        count ++;
        Thread.currentThread().setName("name is:"+count+" : ");
        System.out.println(Thread.currentThread().getName()+"count:"+count);
    }

    public static void main(String[] args) {
        SyncTest st = new SyncTest();
        for (int i = 0;i <100;i++){
            new Thread(st).start();
        }
    }
}
