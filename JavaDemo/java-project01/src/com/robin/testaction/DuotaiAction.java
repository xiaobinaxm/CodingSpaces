package com.robin.testaction;

/**
 * @Description
 * @Author Robin
 * @Date 2019/9/30 10:24
 */
public class DuotaiAction {

    public static void main(String[] args) {
        fu f = new zi();//想上装，直接使用即可
        System.out.println(f.num);
       //System.out.println(f.num2);//Cannot resolve symbol 'num2'

        ((zi) f).fly();//使用子类的方法，必须进行强转，也就是下转型
        f.method();
        //f.function();//Cannot resolve method 'function()'

    }
}


class fu{
    int num = 10;
    public void show(){
        System.out.println("fu...show");
    }

    public void method(){
        System.out.println("Fu...method");
    }
}


class zi extends fu{
    int num = 20;
    int num2 = 300;
    public void fly(){
        System.out.println("zi...fly");
    }
    public void function(){
        System.out.println("zi...function");
    }
}