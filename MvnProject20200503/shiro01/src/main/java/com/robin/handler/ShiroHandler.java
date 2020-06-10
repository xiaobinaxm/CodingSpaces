package com.robin.handler;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/21 9:39
 */
@RequestMapping("/shiro")
@Controller
public class ShiroHandler {

    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        Subject subject = SecurityUtils.getSubject();
        //判断当前对象是否已经登录
        if (!subject.isAuthenticated()) {
            //将用户名和密码封账掉UsernamePasswordToken对象中
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            //记住我  rememberMe
            token.setRememberMe(true);
            try {
                subject.login(token);
             //所有认证异常类的父类
            } catch (AuthenticationException e) {
                e.printStackTrace();
                System.out.println("登录失败！" + e.getMessage());
            }
        }
        //return "success";//此处没有success页面，我们执行跳转
        return "redirect:/list.jsp";
    }


    @RequestMapping("/login2")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("rememberMe") String rememberMe){
        // 1. 获取当前用户
        Subject currentUser = SecurityUtils.getSubject();
        // *2. 判断是否登录,没有登陆返回false
        if (!currentUser.isAuthenticated()) {
            // 3。 封装用户名和密码
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            try {
                // 判断是否记住我
                if("on".equals(rememberMe)){
                    token.setRememberMe(true);
                }

                // 4. 登录
                currentUser.login(token);
            } catch (AuthenticationException e) { // 6.3.4 其他的认证异常
                System.out.println("认证失败。。。。");
                System.out.println("登录失败！" + e.getMessage());
                return "login";
            }
        }
        return "redirect:/list.jsp";
    }

}
