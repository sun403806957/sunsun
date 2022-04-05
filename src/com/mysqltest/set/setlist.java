package com.mysqltest.set;

import java.util.HashSet;

public class setlist {
    public static void main(String[] args) {
        HashSet <Student> a = new HashSet<Student>();
        a.add(new Student("lulu",12));
        a.add(new Student("lulu",12));
        System.out.println(a.size());
        for (Student b:a){
            System.out.println(b);
        }
        System.out.println(a);
    }
}
