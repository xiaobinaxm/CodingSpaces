package com.robin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/20 1:31
 */
//@RestController //这个直接返回的是json字符串
@Controller //可以定位到user.jsp页面
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        System.out.println("hello,let's do some things,test spring-mvc.xml file....");
        return "list";
    }


    //admin权限
    @GetMapping("/admin")
    public String admin() {
        System.out.println("This is admin .....");
        return "list";
    }

    //user权限
    @GetMapping("/user")
    public String user() {
        System.out.println("This is user ....");
        return "list";
    }
}
