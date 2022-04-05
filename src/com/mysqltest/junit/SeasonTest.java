package com.mysqltest.junit;

import org.w3c.dom.ls.LSOutput;

public class SeasonTest {
    public static void main(String args[]){

    //season season = new season("12","12");
        //System.out.println(season.SPRING.toString());
        //System.out.println(SeasonEnum.SPRING.getSeasonName());
        SeasonEnum2[] sea  = SeasonEnum2.values() ;
        int i = 0;
        for (i = 0;i < sea.length;i ++){
            sea[0].show();
        }
    }
}
