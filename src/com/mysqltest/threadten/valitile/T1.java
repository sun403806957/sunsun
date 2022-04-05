package com.mysqltest.threadten.valitile;

public class T1 {
    /*final*/ Object o = new Object();
    void m1(){
        synchronized (o){
            while (true){
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        T1 t1 = new T1();
        new Thread(t1::m1,"t1").start();
        new Thread(t1::m1,"t2").start();
        t1.o = new Object();

    }
}
