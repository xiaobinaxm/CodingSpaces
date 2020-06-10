package com.robin.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author Robin
 * @Date 2020/5/1 0:03
 */
@Controller
public class ShiroController {

    @RequestMapping({"/", "index", "index.html"})
    public String toIndex(Model model) {
        model.addAttribute("msg", "Hello Shiro...........");
        return "index";
    }


    @GetMapping("/add")
    public String add() {
        return "add";
    }

    @GetMapping("/update")
    public String update() {
        return "update";
    }


    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";//这个login是跳转到login.html页面的
    }


    @RequestMapping("/login")//这个login是匹配跳转请求的，前端login页面发起Action提交之后，条状到此处
    public String login(String username, String password,Model model) {
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登陆数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        token.setRememberMe(true);
        //执行登陆的方法,如果没有异常，就说明OK
        try {
            subject.login(token);
            return "index";//登陆成功，返回首页
        }catch (UnknownAccountException e){ //用户名不存在
            model.addAttribute("msg", "用户名错误");
            return "login";
        }catch (IncorrectCredentialsException e){ //密码不存在
            model.addAttribute("msg","密码错误");
            return "1ogin";
        }
    }


    @RequestMapping("/noauth")
    @ResponseBody
    public String unAuthorized() {
        return "没有授权，不能访问！";
    }



}
