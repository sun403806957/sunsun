package com.mysqltest.threadtest.sync;

public class Test2 {
    private  int count = 0;
    public synchronized void m1(){
        count ++;
        System.out.println("***********"+Thread.currentThread().getName()+" m1 start");
        System.out.println("count:"+count);
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("***********"+Thread.currentThread().getName()+" m1 end");
    }
    public  void m2(){
        count ++;
        System.out.println("***********"+Thread.currentThread().getName()+" m2 start");
        System.out.println("count:"+count);
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("***********"+Thread.currentThread().getName()+" m2 end");
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        Thread t1 = new Thread(test2::m1,"t1");
        Thread t2 = new Thread(test2::m2,"t2");
        t1.start();
        t2.start();
    }
}
