package com.mysqltest.threadtest.volatiletest;

import java.util.concurrent.TimeUnit;

public class VolutileTest {
   /* volatile*/ boolean running = true;
    int count = 0;
      void m(){
          System.out.println("m start ......");
        while(running){
            count ++;
            //System.out.println(count);
            //System.out.println("m is running .......");
          /*  try{
                TimeUnit.MICROSECONDS.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }*/
        }
          System.out.println("m end ！！！！");
    }

    public static void main(String[] args) {
        VolutileTest vt = new VolutileTest();
        new Thread(vt::m,"t1").start();
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        vt.running = false;
        System.out.println("count"+vt.count);
    }
}
