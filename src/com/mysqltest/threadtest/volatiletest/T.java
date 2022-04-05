package com.mysqltest.threadtest.volatiletest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class T {
    volatile int count = 0;
    synchronized void m(){
        for (int i =0 ;i <10000;i++){
            count ++;
        }
    }

    public static void main(String[] args) {
        T t = new T();
         List<Thread> tlist = new ArrayList<>();
        for (int i =0 ;i<10;i++){
            tlist.add(new Thread(t::m,"thread"+i));
        }
        tlist.forEach((o)->o.start());
        tlist.forEach((o)->{
            try{
                o.join();
            } catch (InterruptedException e){

            }
        });
        System.out.println(t.count);
    }
}
