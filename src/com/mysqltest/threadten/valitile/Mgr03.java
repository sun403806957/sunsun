package com.mysqltest.threadten.valitile;

import org.w3c.dom.ls.LSOutput;

import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

public class Mgr03 {
    private static Mgr03  INSTANCE;
    private Mgr03(){

    }
    public static Mgr03 getINSTANCE(){
        if (INSTANCE ==null){
            try{
                TimeUnit.MICROSECONDS.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i =0 ;i<100;i++){
            new Thread(()->{
                System.out.println(Mgr03.getINSTANCE().hashCode());
                }).start();
        }
    }
}
