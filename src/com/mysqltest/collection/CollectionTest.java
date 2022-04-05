package com.mysqltest.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class CollectionTest {
    public static void main(String[] args) {
         /*
        Collection接口的常用方法：
        增加：add(E e) addAll(Collection<? extends E> c)
        删除：clear() remove(Object o)
        修改：
        查看：iterator() size()
        判断：contains(Object o)  equals(Object o) isEmpty()
         */
        Collection c = new ArrayList();
        c.add(18);
        c.add(12);
        System.out.println(c);
        for (Object o :c){
            System.out.println(o);
                 }
        Iterator it = c.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("=====================");
        ArrayList llist = new ArrayList();
        llist.add("abc");
        llist.add(1);
        Iterator lit = llist.iterator();
        while (lit.hasNext()){
            System.out.println(lit.next());
        }
       // verctor verctor = new Verctor();
       Vector v=new Vector();
       ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
       //al.add("");
    }


}

