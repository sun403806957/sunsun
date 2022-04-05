package com.mysqltest.collection;
//编写一个函数，实现如下功能：
//        - 输入：2,3,5,6,1,2,4
//        - 输出#1：6,1,5,2,4,2,3
import java.util.*;

public class TestSortList {
    public static void main(String[] args) {
        Integer[] a = new Integer[7];
        a[0]= 2;
        a[1]= 3;
        a[2]= 5;
        a[3]= 6;
        a[4]= 1;
        a[5]= 2;
        a[6]= 4;
       List<Integer> ints = Arrays.asList(a);
        ArrayList<Integer> result = new ArrayList<>();
        Collections.sort(ints);
        for(int i =0;i<ints.size();i++){
            if ((ints.size()-i-1)>(ints.size()/2)){
                result.add( ints.get( ints.size()-i-1 ) );
                result.add( ints.get( i ) );
            }else {
                result.add( ints.get( i ) );
                break;
            }
        }
        for (Integer i:result){
            System.out.println(i);
        }
    }

}
