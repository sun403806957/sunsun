package com.mysqltest.threadtest;

import java.net.PortUnreachableException;

public class TT implements Runnable{
     int b =100;
     public synchronized void m1()throws Exception{
         b = 10000;
         Thread.sleep(5000);
         System.out.println(Thread.currentThread().getName()+"b= "+b);
         //m2();
     }
     public void m2()throws Exception{
         m1();
         System.out.println(Thread.currentThread().getName()+"m2"+b++);
     }
     public void run (){
            try{
                m2();
            }catch (Exception e){
                e.printStackTrace();
            }
    }

    public static void main(String[] args) throws Exception {
        TT tt = new TT();
        Thread t = new Thread(tt);
        t.start();
        Thread.sleep(1000);
        t.join();
        tt.m2();

        System.out.println(tt.b);
    }
}
