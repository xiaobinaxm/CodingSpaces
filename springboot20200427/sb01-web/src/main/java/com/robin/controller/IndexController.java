package com.robin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/28 10:43
 */
@Controller
public class IndexController {


    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }


}
