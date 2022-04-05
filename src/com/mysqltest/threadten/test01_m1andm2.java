package com.mysqltest.threadten;
/*
* 没有加锁的方法可以在加锁的方法执行的时候执行，不需要等锁
* 如：syc m1() m2()
* 如果两个方法都需要改一个变量，两个方法都需要加锁
* */
public class test01_m1andm2 {
}
