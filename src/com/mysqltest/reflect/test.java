package com.mysqltest.reflect;

import com.sun.source.tree.NewArrayTree;

import java.lang.reflect.Constructor;

public class test {
    public static void main(String[] args) throws Exception {
        /*
        Person p = new Person();
        //方式1：通过getClass()方法获取
        Class cp = p.getClass();
        //方式2：通过内置class属性：
        Class cp2 = Person.class;
        //方式3：用的最多，调用class类提供的静态方法forname
        Class cp3 = Class.forName("com.mysqltest.reflect.Person");
        //方法4：利用类的加载器
        ClassLoader loader = test.class.getClassLoader();
        Class cp4 = loader.loadClass("com.mysqltest.reflect.Person");
         */
        Class sc = Student.class;
        Constructor[] sc1 = sc.getConstructors();
        Constructor[] sc2 = sc.getDeclaredConstructors();
        for (Constructor c:sc1){
            System.out.println(c);
        }
        for(Constructor c: sc2){
            System.out.println(c);
        }
    }
}
