package com.mysqltest.threadtest.proconsumer;

public class PruducerConsmer {
    public static void main(String[] args) {
            SyncStack mss = new SyncStack();
            Producer p = new Producer(mss,"生产者0");
            Consumer c = new Consumer(mss,"消费者0");
            Consumer c1 = new Consumer(mss,"消费者1");
            Consumer c2 = new Consumer(mss,"消费者2");
            Thread pt = new Thread(p);
            Thread ct = new Thread(c);
            Thread ct1 = new Thread(c1);
            Thread ct2 = new Thread(c2);
            pt.start();
            ct.start();
            ct1.start();
            ct2.start();

    }
}
class WoTou{
    int id ;
    public WoTou(int id){
        this.id = id;
    }
    public String toString(){
        return "wotou:"+id;
    }
}
class SyncStack{
    int index=0;
    WoTou [] arrWoTou = new WoTou[6];
    public synchronized void push(WoTou w) {
        while (index == arrWoTou.length){
            try {
                this.wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.notify();
        arrWoTou[index++] = w ;
    }
    public synchronized WoTou pop(){
        while (index == 0){
            try {
                this.wait();
            }catch (InterruptedException e){e.printStackTrace();}
        }
        this.notify();
        return arrWoTou[--index];
    }
}
class Producer implements Runnable{
    SyncStack ss = null;
    private String name;
    Producer (SyncStack ss,String name){
        this.ss = ss;
        this.name = name;
    }
    public void run(){
        for (int i = 0 ;i <20;i++){
            WoTou pwt = new WoTou(i);
            ss.push(pwt);
            System.out.println(this.name+"生产窝头"+pwt);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
class Consumer implements Runnable{
    SyncStack ss = null;
    private String name ;
    Consumer (SyncStack ss,String name){
        this.ss = ss;
        this.name = name;
    }
    public void run(){
        for (int i = 0 ;i <20;i++){
            WoTou cwt = ss.pop();
            System.out.println(this.name+"消费窝头"+cwt);
            //System.out.println(cwt);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}