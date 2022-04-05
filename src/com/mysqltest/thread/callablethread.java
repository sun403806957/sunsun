package com.mysqltest.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class callablethread implements Callable {
    int tiketnum = 10;
    @Override
    public  Object  call() throws Exception{
        for (int i =1;i <=100;i++){
            if (tiketnum >0){
                System.out.println("我在"+Thread.currentThread().getName()+"买到第"+tiketnum--+"张车票");
            }
        }
        return null;
    }

}
 class calltest{
    public static void main(String[] args)throws Exception {
        callablethread ct;
        ct = new callablethread();
        FutureTask ft = new FutureTask(ct);
        Thread t1 = new Thread(ft);
        Thread t2 = new Thread(ft);
        Thread t3 = new Thread(ft);
        t1.start();
        t2.start();
        t3.start();
        t3.join();
        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        System.out.println(t3.getPriority());
    }
}
