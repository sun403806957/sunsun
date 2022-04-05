package com.mysqltest.threadten;

public class Test01_syc implements Runnable {
    Timer timer = new Timer();
    public static void main(String[] args) {
        Test01_syc ts01 = new Test01_syc();
        Thread t1 = new Thread(ts01,"t1");
        Thread t2 = new Thread(ts01,"t2");
        t1.start();
        t2.start();
    }
    @Override
    public void run(){
        timer.add(Thread.currentThread().getName());
    }
}
class Timer{
    private   int num = 0;
    public  synchronized void add(String name ){
        num ++;
        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(name+"你是第"+num+"个使用timer的线程");
    }
}
