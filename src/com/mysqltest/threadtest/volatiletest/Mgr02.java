package com.mysqltest.threadtest.volatiletest;

public class Mgr02 {
    private static final Mgr02 INSTANCE ;
    static {
        INSTANCE = new Mgr02();
    }
    private Mgr02(){

    }
    public Mgr02 getINSTANCE(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        Mgr02 m21 = new Mgr02();
        Mgr02 m22 = new Mgr02();
        System.out.println(m21 == m22);
    }
}
