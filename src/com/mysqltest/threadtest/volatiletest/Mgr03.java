package com.mysqltest.threadtest.volatiletest;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.concurrent.TimeUnit;

public class Mgr03 {
    private static Mgr03 INSTANCE;
    private Mgr03(){

    }
    public static Mgr03 getINSTANCE(){
        if (INSTANCE ==null){
            try {
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }
    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i =0 ; i<100;i++){
            new Thread(()->{
                System.out.println(Mgr03.getINSTANCE().hashCode());
            }).start();
        }

    }
}
