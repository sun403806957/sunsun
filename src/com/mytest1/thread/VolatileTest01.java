package com.mytest1.thread;

import java.util.concurrent.TimeUnit;

public class VolatileTest01 {
     boolean flag = true;
    int count=0;
    public void m() {
        System.out.println("m"+"开始运行"+flag);
        while (flag) {
            count ++;
        }
        System.out.println("m"+"停止运行");
    }


    public static void main(String[] args) {
        VolatileTest01 vt1 = new VolatileTest01();
        new Thread(vt1::m,"t1").start();

        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            System.out.println("睡眠被打断了不开心");
        }

        vt1.flag = false;
        System.out.println("count"+vt1.count);
    }
}
