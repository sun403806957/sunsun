package com.mysqltest.junit;

public enum SeasonEnum2 implements enumtest{
    SPRING{
        public void show(){
            System.out.println("这是春天");
        }
    },
    SUMMER {
        public void show(){
            System.out.println("这是夏天");
        }
    },
    AUTOUM{
        public void show(){
            System.out.println("这是秋天");
        }
    },
    WINTER{
        public void show(){
            System.out.println("这是冬天");
        }
    };
}
