package com.mytest1.thread;

import java.util.concurrent.TimeUnit;

public class Mgr05 {
    private static Mgr05 INSTANCE;
    private Mgr05(){}
    public static Mgr05 getINSTANCE(){
        if (INSTANCE ==null){
            synchronized (Mgr05.class) {
                if(INSTANCE==null) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    INSTANCE = new Mgr05();
                }
            }
        }
        return INSTANCE;
    }
    public static void main(String[] args) {
        Mgr01 m1 = Mgr01.getInsternce();
        Mgr01 m2 = Mgr01.getInsternce();
    }
}
