package com.mytest1.thread;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Castest01 {
    AtomicInteger count = new AtomicInteger();
    void m1(){
        for (int i =0;i <10000;i++){
            count.addAndGet(1);
        }
    }

    public static void main(String[] args) {
        Castest01 cas01 = new Castest01();
        List<Thread> tlist = new ArrayList<Thread>();
        for (int i = 0;i <100;i++){
            tlist.add(new Thread(cas01::m1));
        }
        tlist.forEach((o)->{
            o.start();
        });
        tlist.forEach((o)->{
           try{
               o.join();
           }catch (InterruptedException e){
               e.printStackTrace();
           }
        });
        System.out.println(cas01.count);
    }

}
