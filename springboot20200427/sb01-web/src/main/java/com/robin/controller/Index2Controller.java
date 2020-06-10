package com.robin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/27 23:42
 */
@Controller
public class Index2Controller {

    @GetMapping("/index2")
    public String index(Model model) {
        model.addAttribute("msg", "<h1>hello Springboot</h1>");
        model.addAttribute("users", Arrays.asList("robin", "xiaobin", "shuai"));

        return "index2";
    }


    @GetMapping("/test")
    public String test() {
        return "test";
    }

}
