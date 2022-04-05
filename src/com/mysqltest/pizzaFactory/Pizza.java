package com.mysqltest.pizzaFactory;
//披萨的父类

/**
 * 披萨的属性有名称大小和价格
 *
 */
public class Pizza {
    //属性
    private String name ;
    private int price;
    private int size;
    //方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

        public int getPrice() {
            return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    //展示pizza信息
    public String showPizza(){
       return "披萨的名字："+name+"\n披萨的尺寸："+size+"寸\n披萨的价格："+price+"元" ;
    }
    public Pizza() {
    }

    public Pizza(String name, int price, int size) {
        this.name = name;
        this.price = price;
        this.size = size;
    }
}
