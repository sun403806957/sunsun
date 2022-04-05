package com.mytest1.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WithoutVolatile {
    volatile List lists = new ArrayList();
    public void add(Object o ){
        lists.add(o);
    }
    public int size(){
        return lists.size();
    }

    public static void main(String[] args) {
        WithoutVolatile wo = new WithoutVolatile();
        new Thread(()->{
            for (int i = 0;i<10;i++){
                wo.lists.add(new Object());
                System.out.println("add"+i);
                try{
                    TimeUnit.SECONDS.sleep(1);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(()->{
            //System.out.println("线程2也在运行");
            System.out.println(wo.size());
            while (true) {
                if(wo.size()==5) {
                    //System.out.println("线程2停止运行了");
                    break;
                }
            }
            System.out.println("t2 结束");
        }).start();
    }
}
