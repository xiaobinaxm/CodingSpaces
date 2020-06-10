package com.robin.springbootjsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/4 22:52
 */
@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model,String name){
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("hello2")
    public String hello2(){
        System.out.println("hello22222");
        return "hello";
    }
}
