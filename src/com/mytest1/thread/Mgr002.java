package com.mytest1.thread;

public class Mgr002 {
   private static final Mgr002 INSTANCE ;
   static {
       INSTANCE = new Mgr002();
   }
    private Mgr002(){

    }
    public static Mgr002 getINSTANCE(){
        return  INSTANCE;
    }
}


