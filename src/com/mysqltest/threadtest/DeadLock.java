package com.mysqltest.threadtest;

import javax.crypto.spec.PSource;

public class DeadLock implements Runnable {
    public  int flag ;
    static Object o1=new Object() , o2 = new Object();
    @Override
    public  void  run (){
        System.out.println("flag:"+flag);
        if (flag == 1){
            synchronized (o1){
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){

                }
                synchronized (o2){
                    System.out.println("1");
                }
            }

        }
        if (flag == 0){  
            synchronized (o2){
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){

                }
                synchronized (o1){
                    System.out.println("0");
                }
            }

        }
    }
    public static void main(String[] args) {
        DeadLock dl1 = new DeadLock();
        DeadLock dl2 = new DeadLock();
        dl1.flag = 1;
        dl2.flag = 0;
        Thread t1 = new Thread(dl1);
        Thread t2 = new Thread(dl2);
        t1.start();
        t2.start();
    }
}
