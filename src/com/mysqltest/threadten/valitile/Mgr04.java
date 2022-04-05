package com.mysqltest.threadten.valitile;

import java.util.concurrent.TimeUnit;

public class Mgr04 {
    private static Mgr04  INSTANCE;
    private Mgr04(){

    }
    public static synchronized Mgr04 getINSTANCE(){
        if (INSTANCE ==null){
            try{
                TimeUnit.MICROSECONDS.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            INSTANCE = new Mgr04();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i =0 ;i<100;i++){
            new Thread(()->{
                System.out.println(Mgr04.getINSTANCE().hashCode());
            }).start();
        }
    }
}
