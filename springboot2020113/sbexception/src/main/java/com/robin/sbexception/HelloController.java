package com.robin.sbexception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/6 12:20
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        int i = 1/0;
        String x = "1234gfergr4yntyu6";
        String substring = toString().substring(3, 8);
        System.out.println(substring);
        return "hello";
    }


    //拦截器问题
    @GetMapping("/interceptor")
    public String interceptor(){
        String[] arr = {"123","4324","5435","4234"};



        return "myInterceptor";
    }

}
