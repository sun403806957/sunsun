package com.mysqltest.threadten;

/*
 * 账户练习
 * */
public class Test01_syc_Aconund {
    public static void main(String[] args) {
        Person p = new Person("mysql");
        Acount a = new Acount(p, 80);
        Thread t1 = new Thread(() -> a.add(100));
        Thread t2 = new Thread(() -> a.add(200));
        Thread t3 = new Thread(() -> a.sub(390));
        t1.start();
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t3.start();
        System.out.println("********************************" + a.sum);
    }
}

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }
}

class Acount {
    Person p;
    double sum = 0.0;

    public Acount(Person p, double sum) {
        this.p = p;
        this.sum = sum;
    }

    public synchronized void add(double extr) {
        this.sum = sum + extr;
        System.out.println("你的账户进账" + extr + "你的账户总额现在为" + this.sum);
    }

    public synchronized Acount sub(double minus) {
        if (sum - minus >= 0) {
            this.sum = sum - minus;
            System.out.println("你的账户将减出" + minus + "你的账户总额现在为" + this.sum);
        } else {
            System.out.println("您的余额已不足，请确定后在进行取钱操作");
            this.sum = sum;
        }
        return this;
    }
}
