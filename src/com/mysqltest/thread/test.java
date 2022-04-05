package com.mysqltest.thread;

public class test {
    public static void main(String[] args) {
        Thread.currentThread().setName("主线橙");
        for (int i =1 ;i<=10;i++){
            System.out.println(Thread.currentThread().getName()+i);
        }
        threadtest tt = new threadtest();
        tt.setName("另外的线🍊");
        tt.start();
      for(int i =1;i<=10;i++){
          System.out.println(Thread.currentThread().getName()+i);
      }
    }
}
