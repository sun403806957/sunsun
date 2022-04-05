package com.mysqltest.threadten;

public class Account {
    String name;
    double balence =0;

    public Account(String name, double balence) {
        this.name = name;
        this.balence = balence;
    }

    public void set(String name, double balence){
        this.name = name ;
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        this.balence = balence;
        System.out.println("set现在账户的总额为"+balence);
    }
    public double getBalence(String name){
        System.out.println("get现在账户的总额为"+balence);
        return  this.balence;
    }

    public static void main(String[] args) {
        Account a = new Account("zhangsan",1000);
        new Thread(()->a.set("zhangsan",20000)).start();

        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        new Thread(()->a.getBalence("zhangsan")).start();

    }
}
