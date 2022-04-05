package com.mysqltest.reflect;

import java.security.ProtectionDomain;

public class Student {
    private String name ;
    private int age ;
    private String six;
    private int score;
    public Student(){}
    Student(int age){
        this.age = age ;
    }
    protected Student(String six){

    }
    private Student(String six,int score){

    }

}
