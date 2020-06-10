package com.robin.sbsecurity02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/10 15:11
 */
@RestController
public class UserController {

    @GetMapping("/hello")
    public String hello() {
        return "hello security this is sbsecurity02!!!";
    }

    @GetMapping("/dba/hello")
    public String dba() {
        return "hello dba security!!!";
    }

    @GetMapping("/admin/hello")
    public String admin() {
        return "hello admin security!!!";
    }

    @GetMapping("/user/hello")
    public String user() {
        return "hello user security!!!";
    }
}
