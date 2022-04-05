package com.mytest.jvm;

public class Megr06 {
    private static Megr06  INSTANCE ;
    private Megr06(){}
    public static Megr06 getINSTANCE(){
        if (INSTANCE ==null){
            synchronized (Megr06.class){
                if (INSTANCE ==null){
                    INSTANCE = new Megr06();
                }
            }
        }
        return INSTANCE;
    }
}
