package com.robin.controller;

import com.robin.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Robin
 * @Date 2020/1/14 0:34
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping(value = "/hello",produces = "text/html;charset=utf-8")
    public String hello(){
        return helloService.sayHello();
    }

}
