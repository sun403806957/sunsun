package com.mysqltest.threadtest01;

import java.util.concurrent.TimeUnit;

public class ThreadTest02 extends Thread{
    @Override
    public void run() {
        for (int i =0;i<10;i++){
            System.out.println("i:"+i);
            try{
                TimeUnit.MICROSECONDS.sleep(100);
            }catch (InterruptedException e){

            }
        }
    }
}
class Test02{
    public static void main(String[] args) {
        ThreadTest02 tt2 = new ThreadTest02();
        tt2.start();
        for (int i =0;i<10;i++){
            System.out.println("j:"+i);
            try{
                TimeUnit.MICROSECONDS.sleep(100);
            }catch (InterruptedException e){

            }
        }
    }
}