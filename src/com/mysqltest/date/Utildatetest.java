package com.mysqltest.date;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class  Utildatetest {
    public static void main(String[] args) {

        new ArrayList();
        Scanner sc = new Scanner(System.in);
        System.out.print( "请输入你要查看的日期：（提示：请按照例如2012-5-6的格式书写）");
        String strdate = sc.next();
        java.sql.Date date = java.sql.Date.valueOf(strdate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        System.out.println("日\t一\t二\t三\t四\t五\t六\t");
        int maxday = cal.getActualMaximum(Calendar.DATE);
        int nowday = cal.get(Calendar.DATE);
        cal.set(Calendar.DATE,1);
        int num = cal.get(Calendar.DAY_OF_WEEK);
        int day = num -1;
        int count = 0;
        for (int i =1;i <=day;i ++){
            System.out.print("\t");
        }
        count = count + day;
        for (int i = 1;i <=maxday ;i++){
            if (i == nowday){
                System.out.print(i+"*"+"\t");
            }else{
                System.out.print(i+"\t");
            }
            count ++;
            if (count %7 ==0){
                System.out.println();
            }
        }
    }
}
