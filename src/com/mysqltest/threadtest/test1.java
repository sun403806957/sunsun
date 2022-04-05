package com.mysqltest.threadtest;

public class test1 implements Runnable{
    Timer t = new Timer();

    public static void main(String[] args) {
        test1  test = new test1();
        //test1  test1 = new test1();
        Thread t1 = new Thread(test,"1");
        Thread t2 = new Thread(test,"2");
        Thread t3 = new Thread(test,"3");
        Thread t4 = new Thread(test,"4");
        Thread t5 = new Thread(test,"5");
        Thread t6 = new Thread(test,"6");
        Thread t7 = new Thread(test,"7");
        Thread t8 = new Thread(test,"8");
        Thread t9 = new Thread(test,"9");
        Thread t10 = new Thread(test,"10");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
    }
    @Override
    public void run(){
        t.add(Thread.currentThread().getName());
    }

}
class Timer {
    private static int num = 0;
    public   synchronized  void add(String name) {
        //synchronized (this) {
            num++;
           /* try {
                Thread.sleep(10);
            } catch (InterruptedException e) {

            }*/
            System.out.println(name + ",你是第" + num + "个使用timer的线程");
        }
    //}
}
