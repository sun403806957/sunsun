package com.mysqltest.threadtest.castest;

import com.mysqltest.threadtest.volatiletest.T;

import java.util.concurrent.TimeUnit;

public class reentranklock01 {
    synchronized void m1(){
        for(int i =0;i <10;i++){
            System.out.println("m1:"+i);
            if (i%2==0) m2();
        }
    }
    synchronized void m2(){
        System.out.println("m2");
    }

    public static void main(String[] args) {
        reentranklock01 r = new reentranklock01();
        Thread t1 = new Thread(r::m1);
        Thread t2 = new Thread(r::m2);
        t1.start();
        t2.start();
        try{
            // t1.join();
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
