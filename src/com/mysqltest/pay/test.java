package com.mysqltest.pay;
import com.mysqltest.pay.Mtwm;
public class test {
    public static void main(String[] args){
        String str = "微信";
        if ("微信".equals(str)){
            pay(new wePay()) ;
        }
        if ("支付宝".equals(str)){
            pay(new aliPay()) ;
        }
    }
    public static void pay(Mtwm mtwm){
        mtwm.payonline();
    }
}
