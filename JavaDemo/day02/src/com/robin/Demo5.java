package com.robin;

import com.sun.javaws.Main;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 创建者：Robin
 */
public class Demo5 {
    public static void main(String[] args) {
        Date date = new Date();//实例化调用的是java.util.Date;这个就是Date与Demo5的区别
        System.out.println(date.toString());

        System.currentTimeMillis();

        System.out.println(System.currentTimeMillis());

        int i = Math.abs(-1);
        System.out.println(i);
        double floor = Math.floor(123);

        Random random = new Random();
        System.out.println(random.nextBoolean());
    }


}
