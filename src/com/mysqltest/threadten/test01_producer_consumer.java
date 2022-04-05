package com.mysqltest.threadten;

public class test01_producer_consumer {
    public static void main(String[] args) {
        stackwotou swtlist = new stackwotou();
        producer p1 = new producer(swtlist);
        producer p2 = new producer(swtlist);
        consumer c1 = new consumer(swtlist);
        consumer c2 = new consumer(swtlist);
        Thread tp1 = new Thread(p1,"生产者一号");
        Thread tp2 = new Thread(p1,"生产者二号");
        Thread tc1 = new Thread(c1,"消费者一号");
        Thread tc2 = new Thread(c1,"消费者二号");
        tp1.start();
        tp2.start();
        tc1.start();
        tc2.start();
        try{
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
       for(wotou w:swtlist.attrwt){
           System.out.println(w);
       }
    }

}
class wotou {
  int id ;
  wotou(int id){
      this.id = id;
  }
  public String toString(){
      return "wotou:"+id;
  }
}
class stackwotou{
    int index = 0;
    wotou [] attrwt = new wotou[6];
    public synchronized void push (wotou wt) {
        while (index ==attrwt.length) {
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.notifyAll();
            attrwt [index] = wt;
            index ++;
    }
    public synchronized wotou pop(){
        while (index ==0) {
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
        this.notifyAll();
            index --;
            return attrwt[index];
    }

}

class producer implements Runnable{
    stackwotou pswt =null;
    public producer (stackwotou pswt){
        this.pswt = pswt;
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    @Override
    public void run(){
        for (int i =0;i <20;i++){
            wotou pwt = new wotou(i);
             pswt.push(pwt);
            System.out.println(Thread.currentThread().getName()+"生产了第"+i+"个窝头："+pwt);
             try{
                 Thread.sleep(1000);
             }catch (InterruptedException e){
                 e.printStackTrace();
             }
        }
    }

}
class consumer implements Runnable{
    stackwotou swt=null ;
    public consumer (stackwotou swt){
        this.swt = swt;
    }
    @Override
    public void run(){
        for (int i =0;i <20;i++){
            wotou cwt = swt.pop();
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"消费了第"+i+"个窝头："+cwt);
        }
    }
}