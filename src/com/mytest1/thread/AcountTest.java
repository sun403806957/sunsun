package com.mytest1.thread;

public class AcountTest {
    public static void main(String[] args) {
        Acount a  = new Acount();
        new Thread(()->{a.setBalance("zhangsan",100.00);}).start();
        new Thread(()->{a.setBalance("zhangsan",200.00);}).start();
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){

        }
        System.out.println(a.getBalance("zhangsan"));
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){

        }
        System.out.println(a.getBalance("zhangsan"));
    }
}
class Acount{
    String name ;
    double balance;
    public void setBalance(String name,double balance){
        this.name = name ;
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){

        }
        this.balance = balance;
    }
    public double getBalance(String name){
        return  this.balance;
    }
}