package com.mytest1.thread;

import com.mysqltest.threadten.valitile.T;

public class TestSyc implements  Runnable{
    Timer timer = new Timer();
    public static void main(String[] args) {
        TestSyc ts = new TestSyc();
        Thread t1 = new Thread(ts,"t1");
        Thread t2 = new Thread(ts,"t2");
        t1.start();
        t2.start();

    }
    public void run(){
        timer.add(Thread.currentThread().getName());
    }
}
class Timer{
    private static int num = 0;
    public void add(String name){
        synchronized (this){
            num++;
            try{
                Thread.sleep(1);
            }catch (InterruptedException e){

            }
            System.out.println(name +"你是第"+num+ "使用这个线程的客人");

        }


    }
}