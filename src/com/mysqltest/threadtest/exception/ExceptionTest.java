package com.mysqltest.threadtest.exception;

import java.util.concurrent.TimeUnit;

public class ExceptionTest {
     synchronized void m1() {
         int count = 0;
         System.out.println(Thread.currentThread().getName() + "start.......");
         while (true) {
             count++;
             System.out.println(Thread.currentThread().getName() + "count:" + count);
             try {
                 TimeUnit.SECONDS.sleep(1);
             } catch (InterruptedException e) {
                 System.out.println("异常了啊啊啊啊啊啊啊");
             }
             if (count == 5) {
                 int i = count / 0;
                 System.out.println(i);
             }
         }
     }
    public static void main(String[] args) {
        ExceptionTest et = new ExceptionTest();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                et.m1();
            }
        };
        Thread t1 = new Thread(r,"t1");
        Thread t2 = new Thread(r,"t2");
        t1.start();
        /*try{
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            System.out.println("噢噢噢噢噢噢噢噢噢噢噢");
        }*/
        t2.start();
    }
}
