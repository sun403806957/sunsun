package com.mysqltest.thread;

public class threadtest extends Thread{
    @Override
        public void run (){
           for (int i = 1;i<=10;i++){
               System.out.println(super.getName()+":"+this.getName()+":"+i);
           }
        }
}
