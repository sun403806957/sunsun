package com.mytest1.thread;

import java.lang.ref.PhantomReference;
import java.net.InetAddress;

public class Mgr01 {
    private final static Mgr01 INSTERNCE= new Mgr01();
    private Mgr01(){

    }
    public static Mgr01 getInsternce(){
        return INSTERNCE;
    }

    public static void main(String[] args) {
        Mgr01 m1 = Mgr01.getInsternce();
        Mgr01 m2 = Mgr01.getInsternce();
    }
}
