package com.robin.sbsecurity01.controller;

import com.robin.sbsecurity01.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/9 19:09
 */
@RestController
public class HelloController {

      @GetMapping("/hello")
    public String hello() {
        return "hello security!";
    }

    @GetMapping("/admin/hello")
    public String admin(){
        return "hello admin!";
    }

    @GetMapping("/user/hello")
    public String user() {
        return "hello user!";
    }


    @GetMapping("/login")
    public String login() {
        return "please login!!!";
    }


    @Autowired
    HelloService helloService;

    @GetMapping("/hello1")
    public String admin1() {
        return helloService.admin();
    }

    @GetMapping("hello2")
    public String user1() {
        return helloService.user();
    }

    @GetMapping("hello3")
    public String hello3() {
        return helloService.users();
    }
}
