package com.mytest1.thread;

public class YieldTest extends Thread {
    //YieldTest(String name){super(name);}
    public void  run(){
        for (int i = 1;i<100;i++){
            System.out.println("i am " + getName());
            if (i %3 ==0)  {
                System.out.println("i:"+i);
                Thread.yield();
            }
        }
    }
}
class test002{
    public static void main(String[] args) {
        YieldTest ytest001 = new YieldTest();
        YieldTest ytest002 = new YieldTest();
        ytest001.start();
        ytest002.start();
    }
}