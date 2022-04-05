package com.mysqltest.threadtest.acount;


import java.util.concurrent.TimeUnit;

public class test3 {
    String name ;
    double balance;
    public synchronized void set(String name ,double balance){
        this.name = name;
        //this.balance = balance;
        try{
            TimeUnit.MICROSECONDS.sleep(2000);
            //Thread.sleep(2000);
        }catch (InterruptedException E){

        }
       // this.name = name;
        this.balance = balance;
    }
    public double get(String name){
        return this.balance;
    }

    public static void main(String[] args) {
        test3  t3 = new test3();
        new Thread(()->t3.set("zhangsan",100)).start();
        try{
            TimeUnit.MICROSECONDS.sleep(1000);
            //Thread.sleep(2000);
        }catch (InterruptedException E){

        }
        System.out.println(t3.get("zhangsan"));
        try{
            TimeUnit.MICROSECONDS.sleep(1000);
            //Thread.sleep(2000);
        }catch (InterruptedException E){

        }
        System.out.println(t3.get("zhangsan"));
    }
}
 class t4 extends  test3{
     public  void set(String name ,double balance){
     }
}
/* class Account{
    String name ;
    double balance;
    public synchronized void set(String name ,double balance){
        this.name = name;
        try{
            Thread.sleep(2000);
        }catch (InterruptedException E){

        }
        this.balance = balance;
    }
    public  synchronized double getBalance(String name){
        return this.balance;
    }

    public static void main(String[] args) {
        Account a = new Account();
        new Thread(()->a.set("zhangsan",100)).start();
        try{
            Thread.sleep(1000);
        }catch (InterruptedException E){

        }
        System.out.println(a.getBalance("zhangsan"));
        try{
            Thread.sleep(1000);
        }catch (InterruptedException E){

        }
        System.out.println(a.getBalance("zhangsan"));
    }
}*/
