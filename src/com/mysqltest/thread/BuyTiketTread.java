package com.mysqltest.thread;

public class BuyTiketTread extends Thread{
    public static int tiketnum =4;
    @Override
    public void run(){
        for (int i =1;i <=100;i++){
            if (tiketnum >0){
                System.out.println("我在"+this.getName()+"买到第"+tiketnum--+"张车票");

            }
        }
    }
}
