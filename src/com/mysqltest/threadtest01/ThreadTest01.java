package com.mysqltest.threadtest01;

import java.util.concurrent.TimeUnit;

public class ThreadTest01 implements Runnable{
    @Override
    public void run(){
        for (int i =0;i<10;i++){
            System.out.println("i:"+i);
            try{
                TimeUnit.MICROSECONDS.sleep(1000);
            }catch (InterruptedException e){

            }
        }
    }
}
 class Test01{
     public static void main(String[] args) {
         ThreadTest01 tt1 = new ThreadTest01();
         Thread t = new Thread(tt1);
         t.start();
         for (int i =0;i<10;i++){
             System.out.println("j:"+i);
         }
     }
}