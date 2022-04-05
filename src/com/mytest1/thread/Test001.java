package com.mytest1.thread;

public class Test001 {
   /*private  int count = 1;
    Object o = new Object();
    public void m(){
        synchronized (o) {
            count--;
            System.out.println(Thread.currentThread().getName() + "count:" + count);
        }
    } */
    private static int count =1;
    public static void m(){
        count --;
        System.out.println(Thread.currentThread().getName() + "count:" + count);
    }
    public static void mm(){
        synchronized (Test001.class){

        }
       //synchronized (this.class);
    }
}
