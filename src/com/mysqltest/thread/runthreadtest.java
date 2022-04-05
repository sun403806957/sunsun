package com.mysqltest.thread;

public class runthreadtest {
    public static void main(String[] args) {
        runthread rt1 = new runthread();
        Thread td1  = new Thread(rt1,"窗口1");
        Thread td2  = new Thread(rt1,"窗口2");
        Thread td3  = new Thread(rt1,"窗口3");
        td2.start();
        td1.start();

        td3.start();
    }
}
