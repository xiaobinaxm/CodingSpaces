package com.robin.sbtest1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/9 15:13
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(String name) {
        return "hello" + name;
    }

    @PostMapping("/book")
    public Book addBook(@RequestBody Book book) {
        return book;
    }

}
