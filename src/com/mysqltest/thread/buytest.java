package com.mysqltest.thread;

public class buytest {
    public static void main(String[] args) {
        String cname ="主线橙";
        BuyTiketTread bt1 = new BuyTiketTread();
        bt1.start();
        BuyTiketTread bt2 = new BuyTiketTread();
        bt2.start();
        BuyTiketTread bt3 = new BuyTiketTread();
        bt3.start();

    }
}
