package com.mysqltest.threadtest.castest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class ActomacSycLongadder {
    static AtomicLong count1 = new AtomicLong();
    static long count2 = 0l;
    static LongAdder count3 = new LongAdder();
    public static void main(String[] args) throws Exception {
        Thread[] threads = new Thread[1000];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int k = 0; k < 100000; k++) {
                    count1.incrementAndGet();
                }
            });
        }
        long starttime = System.currentTimeMillis();
        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();
        long endtime = System.currentTimeMillis();
        System.out.println("atomic 花费时间为：" + (endtime - starttime));
        Object o = new Object();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int k = 0; k < 100000; k++) {
                        synchronized (o) {
                            count2++;
                        }
                    }
                }
            });
        }
        starttime = System.currentTimeMillis();
        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();
        endtime = System.currentTimeMillis();
        System.out.println("synch 花费时间为：" + (endtime - starttime));

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int k = 0; k < 100000; k++) count3.increment();
            }
            );
        }
        starttime = System.currentTimeMillis();
        for (Thread t:threads) t.start();
        for(Thread t:threads) t.join();
        endtime =System.currentTimeMillis();
        System.out.println("longadder 花费时间为："+(endtime -starttime));
    }
}
