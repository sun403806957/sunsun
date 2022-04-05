package com.mysqltest.threadtest.castest;

import sun.misc.Unsafe;

public class unsafetest {
    static class M {
        private M(){
        }
        int i =0;
    }
    public static void main(String[] args){
        try {
            Unsafe unsafe = Unsafe.getUnsafe();
            M m = (M) unsafe.allocateInstance(M.class);
            m.i = 9;
            System.out.println(m.i);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
