package com.mysqltest.threadten.valitile;

import java.util.concurrent.TimeUnit;

public class Mgr05 {
    private static Mgr05  INSTANCE;
    private Mgr05(){

    }
    public static  Mgr05 getINSTANCE(){
        if (INSTANCE ==null){
            synchronized (Mgr05.class){
            try{
                TimeUnit.MICROSECONDS.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            INSTANCE = new Mgr05();
        }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i =0 ;i<100;i++){
            new Thread(()->{
                System.out.println(Mgr05.getINSTANCE().hashCode());
            }).start();
        }
    }
}
