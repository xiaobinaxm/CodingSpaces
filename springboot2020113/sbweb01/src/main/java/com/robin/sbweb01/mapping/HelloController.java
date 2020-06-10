package com.robin.sbweb01.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/7 17:48
 */
@Controller
public class HelloController {


    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }


    //配置thymeleaf，此时需要有用一个对应的页面模板template，不然报错
    @GetMapping("/birth")
    public void birth(Date birth){
        System.out.println(birth);
    }
}
