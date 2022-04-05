package com.mysqltest.pizzaFactory;

public class BaconPizza extends Pizza{
    private  double weight;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public BaconPizza() {
    }

    public BaconPizza(String name, int price, int size, double weight) {
        super(name, price, size);
        this.weight = weight;
    }
    //重写父类的show方法
    @Override
    public String showPizza(){
        return super.showPizza()+"\n披萨的重量是："+weight+ '克';
    }
}
