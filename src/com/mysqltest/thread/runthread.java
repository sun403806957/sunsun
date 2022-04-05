package com.mysqltest.thread;

import java.net.PortUnreachableException;

public class runthread implements Runnable{
     int num = 1;
    @Override
    public void run(){
        for (int i =0 ;i <10;i++){
            if(num>0) {
                System.out.println("我在第" + Thread.currentThread().getName() + "窗口" + "买到了第" + num-- + "张票");
            }
        }
    }
}
