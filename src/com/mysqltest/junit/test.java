package com.mysqltest.junit;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;


public class test {
    @Before
    public void init(){
        System.out.println("测试方法开始");
    }
    @After
    public void close(){
        System.out.println("测试方法结束");
    }

    @Test
    public void testAdd(){
     Calculator cal = new Calculator();
     int result = cal.add(10,30);
     System.out.println(result);
 }
     @Test
    public void testSub(){
         Calculator cal = new Calculator();
         int result = cal.sub(10,30);
         System.out.println(result);
     }
}
