package com.mytest1.thread;

import java.util.concurrent.TimeUnit;

public class Mgr03 {
    private static Mgr03 INSTANCE;
    private Mgr03 (){}
    public static Mgr03 getINSTANCE(){
        if (INSTANCE ==null){
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }
}
