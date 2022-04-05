package com.mytest1.thread;

public class JoinTest001 extends Thread{
    public void run(){
        for(int i =0 ;i <10;i++){
            System.out.println("i am "+getName());
            try{
                sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
class test001{
    public static void main(String[] args) {
        JoinTest001 jt001 = new JoinTest001();
        jt001.start();
        try{
            jt001.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        for(int i =0 ;i <10;i++){
            System.out.println("i am main");
        }
    }
}
