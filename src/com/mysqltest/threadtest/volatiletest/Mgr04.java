package com.mysqltest.threadtest.volatiletest;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.concurrent.TimeUnit;

public class Mgr04 {
    private static Mgr04 INSTANCE;
    private Mgr04(){

    }
    public synchronized static Mgr04 getINSTANCE(){
        if (INSTANCE ==null){
            try {
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            INSTANCE = new Mgr04();
        }
        return INSTANCE;
    }
    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i =0 ; i<100;i++){
            new Thread(()->{
                System.out.println(Mgr04.getINSTANCE().hashCode());
            }).start();
        }

    }
}
