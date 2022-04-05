package com.mysqltest.threadten.valitile;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class T {
    volatile  int count = 0;
    public /*synchronized */void count() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        T t = new T();
        List <Thread> ts = new ArrayList<Thread>() ;
        for (int i = 0; i < 10; i++) {
            ts.add(new Thread(t::count));
        }
        ts.forEach((o)->o.start());
        ts.forEach((o)->{
            try {
                o.join();
            }catch (InterruptedException e ){
                e.printStackTrace();
            }
        });
        System.out.println(t.count);
    }
}
