package com.mysqltest.threadten.valitile;

import java.util.concurrent.TimeUnit;

public class volatiletest {
   volatile boolean running = true;
    public void m1(){
        System.out.println("m1 start.......");
        while (running){

        }
        System.out.println("m1 end ......");
    }

    public static void main(String[] args) {
        volatiletest vt = new volatiletest();
        new Thread(vt::m1).start();
        try {
            TimeUnit.MICROSECONDS.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        vt.running = false;
    }
}
