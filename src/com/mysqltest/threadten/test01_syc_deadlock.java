package com.mysqltest.threadten;

public class test01_syc_deadlock {
    public static void main(String[] args) {
        deadlock dl1 = new deadlock();
        dl1.flag =1;
        deadlock dl2 = new deadlock();
        dl2.flag =2;
        Thread t1 = new Thread(dl1::test);
        Thread t2 = new Thread(dl2::test);
        t1.start();
        t2.start();
    }
}
class deadlock{
    int flag = 0;
    static Object o1 = new Object();
    static Object o2 = new Object();
    public void test() {
        System.out.println("flag:"+flag);
        if (flag == 1) {
            synchronized (o1) {
                System.out.println("o1");
                try{
                    Thread.sleep(10000);
                }catch (InterruptedException e){
                    System.out.println("，不开心-_-");}
                synchronized (o2) {

                    System.out.println("$$$$$$$$$$$$$$$");
                }
            }
        }
        if (flag == 2) {
            synchronized (o2) {
                System.out.println("o2");
                try{
                    Thread.sleep(10000);
                }catch (InterruptedException e){
                    System.out.println("，不开心-_-");}
                synchronized (o1) {
                    System.out.println("##################");
                }
            }
        }
    }
}