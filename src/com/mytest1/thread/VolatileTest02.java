package com.mytest1.thread;

import java.util.*;

public class VolatileTest02 {
     int count = 0;
   synchronized void m1(){
        for (int i = 0;i <10000;i++){
            count ++;
        }
    }

    public static void main(String[] args) {
        VolatileTest02 vt2 = new VolatileTest02();
        List<Thread> tlist = new ArrayList<Thread>();
        for (int i = 0;i<10;i++){
            tlist.add(new Thread(vt2::m1));
        }
        tlist.forEach((o)->o.start());
        tlist.forEach((o)->{
            try{
                o.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        System.out.println("count"+vt2.count);
    }
}
