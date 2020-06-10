package com.robin.sbshiro01.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @Description
 * @Author Robin
 * @Date 2020/4/11 19:41
 */
@RestController
public class HelloController {

    @GetMapping("/login")
    public String login() {
        return "please login!!!";
    }


    @PostMapping("/doLogin")
    public void doLogin(String username,String password) {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username,password));
            System.out.println("congratulation,success!!!");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("fail>>>>" + e.getMessage());
        }
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello shiro coming here....";
    }

}
