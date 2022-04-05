package com.mysqltest.threadtest.castest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest_01 {
    AtomicInteger count = new AtomicInteger(0);
    /*synchronized */ void m(){
        for(int i =0 ;i<1000;i++){
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        AtomicIntegerTest_01 t = new AtomicIntegerTest_01();
        List<Thread> threads = new  ArrayList<>();
        for(int i =0 ;i<100;i++){
            threads.add(new Thread(t::m,"thread"+i));
        }
        threads.forEach((o)->o.start());
        threads.forEach((o)->{
            try{
            o.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        System.out.println(t.count);

    }

}
