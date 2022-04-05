package com.mysqltest.pizzaFactory;

import java.util.Scanner;

public class test {
    public static void main(String[] args){
        //选择要购买的披萨
        Scanner sc1 = new Scanner(System.in);
        System.out.println("请输入你想要的披萨（0:原味披萨 1：培根披萨 2：水果披萨）");
        int choice = sc1.nextInt();
        Pizza pizza = PizzaStore.getpizza(choice);
        //System.out.println(pizza.showPizza());
    }
}
