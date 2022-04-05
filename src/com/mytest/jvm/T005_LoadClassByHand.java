package com.mytest.jvm;

public class T005_LoadClassByHand extends ClassLoader{
    public T005_LoadClassByHand (){
       // super.findClass();
    }
    public static void main(String[] args)throws Exception {
        Class clazz = T005_LoadClassByHand.class.getClassLoader().loadClass("com.mytest.jvm.Hello");
        System.out.println(clazz.getName());
    }
}
