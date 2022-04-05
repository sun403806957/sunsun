package com.mytest1.thread;

import java.util.Date;
 class test{
    public static void main(String[] args) {
            SleepTest001 stest001 = new SleepTest001();
            stest001.start();
            /*
            * Thread.sleep 相当于main方法睡眠了。因为main方法没有实现thread类，只能这样去睡眠
            * 继承thread的类可以直接调用sleep方法，因为sleep方法是静态方法
            *
            * */
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){

            }
            stest001.interrupt();
    }
}
 public class SleepTest001 extends Thread{
    public void run(){
        /*
        * 可以打个标签进行结束标记。定义flag= true
        * 需要结束线程时，类的实例调用flag 为flase就可以结束线程了
        * */
        while (true){
            System.out.println("*********"+new Date()+"*************");
            try{
                sleep(10000);
            }catch (InterruptedException e){
                System.out.println("thread is interrupted");
                //return ;
            }
        }
    }

}

