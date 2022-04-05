package com.mysqltest.pizzaFactory;

import java.util.Scanner;

public class PizzaStore {
    //静态方法可以用类命直接引用，非静态方法必须新建类的对象
    public static Pizza getpizza(int choice){
        Scanner sc = new Scanner(System.in);
        Pizza p = null;
        switch (choice){
            case 0:{
                System.out.println("请输入披萨的大小：");
                int size = sc.nextInt();
                System.out.println("请输入披萨的价格：");
                int price = sc.nextInt();
                Pizza pizza = new Pizza("原味披萨",price,size);
                p = pizza;
                break;
            }
            case 1:{
                System.out.println("请输入培根的克数：");
                double weight = sc.nextInt();
                System.out.println("请输入披萨的大小：");
                int size = sc.nextInt();
                System.out.println("请输入披萨的价格：");
                int price = sc.nextInt();
                //将录入的信息封装为对象
                BaconPizza bpizza = new BaconPizza("培根披萨",size,price,weight);
                p = bpizza;
                break;
            }
            case 2:{
                System.out.println("请输入您想要加入的水果：");
                String burbening = sc.next();
                System.out.println("请输入披萨的大小：");
                int size = sc.nextInt();
                System.out.println("请输入披萨的价格：");
                int price = sc.nextInt();
                FruitsPizza fpizza = new FruitsPizza();
                p = fpizza;
                break;
            }

            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }

        return p;
    }
}
