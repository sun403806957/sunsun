package com.mytest1.thread;

import com.mysqltest.threadtest.DeadLock;

import javax.xml.namespace.QName;

public class DeadLockTest implements Runnable{
    int flag;
    static Object o1 = new Object();
    static Object o2 = new Object();
    public void run(){
        if (flag ==0){
            synchronized (o1){
                System.out.println("flag :01");
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){

                }
                synchronized (o2){
                    System.out.println("flag :02");
                }
            }

        }
        if (flag ==1){
            synchronized (o2){
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){

                }
                System.out.println("flag :11");
                synchronized (o1){
                    System.out.println("flag :12");
                }
            }
        }
    }
    public static void main(String[] args) {
        DeadLockTest dt1 = new DeadLockTest();
        DeadLockTest dt2 = new DeadLockTest();
        dt1.flag = 1;
        dt2.flag = 0;
        Thread t1 = new Thread(dt1,"线程1");
        Thread t2 = new Thread(dt2,"线程2" );
        t1.start();
        t2.start();
    }
}
