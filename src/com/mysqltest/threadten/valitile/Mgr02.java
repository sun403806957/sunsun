package com.mysqltest.threadten.valitile;

public class Mgr02 {
    private static final Mgr02 INSTANCE;
    static {
        INSTANCE = new Mgr02();
    }
    private Mgr02(){

    }
    public static Mgr02 getInstance(){
        return  INSTANCE;
    }
    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        Mgr01 m1= Mgr01.getInstance();
        Mgr01 m2 = Mgr01.getInstance();
    }
}
