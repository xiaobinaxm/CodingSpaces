package com.robin.sbsecurity03dy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/11 9:48
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello dynamic security!!!,I'm coming....";
    }

    @GetMapping("/dba/hello")
    public String dba() {
        return "hello dba!!!";
    }

    @GetMapping("/admin/hello")
    public String admin() {
        return "hello admin!!!";
    }

    @GetMapping("/user/hello")
    public String user() {
        return "hello user!!!";
    }
}
