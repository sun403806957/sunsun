package com.mysqltest.pizzaFactory;
/*
水果披萨的
 */
public class FruitsPizza extends Pizza{
    private String burbening;

    public String getBurbening() {
        return burbening;
    }

    public void setBurbening(String burbening) {
        this.burbening = burbening;
    }

    public FruitsPizza() {
    }

    public FruitsPizza(String name, int price, int size, String burbening) {
        super(name, price, size);
        this.burbening = burbening;
    }
    //重写父类的show方法
    @Override
    public String showPizza(){
        return super.showPizza()+"\n披萨的配料是："+burbening;
    }
}
