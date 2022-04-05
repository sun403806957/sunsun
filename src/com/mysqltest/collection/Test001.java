package com.mysqltest.collection;
//编写一个函数，实现如下功能：
//        - 输入：2,3,5,6,1,2,4
//        - 输出#1：6,1,5,2,4,2,3

import com.sun.source.tree.NewArrayTree;

import java.util.List;

public class Test001 {
    public int[] test(int [] args){
        int [] test002 = new int[args.length];
        int len = (int)args.length/2;
        for (int i = 0;i<len;i++){
            test002[i] = args[i];
            test002[i+1] = args[args.length-i-1];
        }
        return test002;
    }
}
class TestMain{
    public static void main(String[] args) {
        Test001 test001 = new Test001();
        int [] result = new int[args.length];
        int [] testList = {2,3,5,6,1,2,4};
        result = test001.test( testList );
    }
}


