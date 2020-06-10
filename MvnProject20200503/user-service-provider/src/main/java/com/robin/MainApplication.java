package com.robin;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/18 0:15
 */
public class MainApplication {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
        //ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("provider.xml");
        context.start();

        System.in.read();//按任意键退出
    }
}
