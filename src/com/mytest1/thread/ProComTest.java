package com.mytest1.thread;

public class ProComTest {
    public static void main(String[] args) {
        WoTouStack wts = new WoTouStack();
        Producer p1 = new Producer(wts);
        Consumer c1 = new Consumer(wts);
        Thread pt1 = new Thread(p1,"生产者一号");
        Thread ct1 = new Thread(c1,"消费者一号");
        pt1.start();
        ct1.start();
    }
}
class WoTou{
    int id ;
    public WoTou(int id ){
        this.id = id ;
    }
    public String toString(){
        return "第"+this.id+"个窝头";
    }
}
class WoTouStack{
    int index = 0;
    WoTou [] wtStack = new WoTou[6];

    public synchronized void push(WoTou w){
        while (index == wtStack.length){
            try {
                this.wait();
            }catch (InterruptedException e){
                System.out.println("满员增加等待时发生异常");
            }
        }
        this.notify();
        wtStack[index++] = w;
             //index ++;
    }
    public synchronized WoTou pop(){
        while(index == 0){
            try {
                this.wait();
            }catch (InterruptedException e){
                System.out.println("已空减少时等待时发生异常");
            }
        }
        this.notify();
        return wtStack[--index];
    }
}
class Producer implements Runnable{
    WoTouStack pwts = null;
    Producer (WoTouStack pwts){
        this.pwts = pwts;
    }
    public void run(){
        for (int i = 0;i<6;i++){
            WoTou  pwt = new WoTou(i);
            System.out.println(Thread.currentThread().getName()+"生产了"+pwt.toString());
            pwts.push(pwt);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }

}
class Consumer implements Runnable{
    WoTouStack cwts = null;
    Consumer (WoTouStack cwts){
        this.cwts = cwts;
    }
    public void run(){
        for (int i =0;i <6;i ++){
            WoTou w = cwts.pop();
            System.out.println(Thread.currentThread().getName()+"消费了"+w.toString());
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}