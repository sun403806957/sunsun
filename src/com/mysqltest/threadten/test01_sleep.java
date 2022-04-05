package com.mysqltest.threadten;

/*
线程的各种状态
* sleep方法的讲解
打断线程的方法
* */
public class test01_sleep {
    public static void main(String[] args) {
        System.out.println("**************************");
        test_sleep ts = new test_sleep();
        Thread t = new Thread(ts);
        t.start();
        try{
            Thread.sleep(10000);
        }catch (InterruptedException e){
            System.out.println("，不开心-_-");}
        Thread.currentThread().interrupt();
        for (int i =0;i<10;i ++){
            try{
                Thread.sleep(10);
            }catch (InterruptedException e){
                System.out.println("主线程睡眠被打断了，不开心-_-");
                return;
            }
            System.out.println("是main线程哦:"+i);
        }
        System.out.println(Thread.interrupted());
               // t.interrupt();
    }
    }


class test_sleep implements Runnable{
    @Override
    public void run(){
        for (int i =0;i<10;i ++){
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println("睡眠被打断了，不开心-_-");
                return;
            }
            System.out.println("不是main线程哦:"+i);
        }
    }
}