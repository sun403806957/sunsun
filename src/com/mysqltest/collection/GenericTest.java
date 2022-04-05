package com.mysqltest.collection;

public class GenericTest<E> {
    int age ;
    String name ;
    E sex;
    public void a (E n){

    }
    public void b(E[] m){

    }
}
class test1{
    public static void main(String[] args) {
        GenericTest gtest = new GenericTest();
        Object o = new Object();
        gtest.a("abc");
        gtest.a(12);
        gtest.a(o);
        gtest.a(new String[] {"a","b","c"});
        gtest.sex= "";
        GenericTest<String> gt2 = new GenericTest<>();
        gt2.sex="男";

    }
}















