package com.robin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @Description 配置页面路由
 * @Author Robin
 * @Date 2020/4/30 14:00
 */
@Controller
public class RouterController {

    //进入首页
    @RequestMapping({"/", "/index", "index.html"})
    public String index() {
        return "index";
    }

    //进入登录页面
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "views/login";
    }


    //采用restful风格，此处设计的还是很巧妙，值得多想下
    //不同等级低额VIP用户，可以进入到不同的页面
    @RequestMapping("/level1/{id}")
    public String level1(@PathVariable("id") int id) {
        return "views/level1/" + id;
    }

    @RequestMapping("/level2/{id}")
    public String level2(@PathVariable("id") int id) {
        return "views/level2/" + id;
    }

    @RequestMapping("/level3/{id}")
    public String level3(@PathVariable("id") int id) {
        return "views/level3/" + id;
    }



}
