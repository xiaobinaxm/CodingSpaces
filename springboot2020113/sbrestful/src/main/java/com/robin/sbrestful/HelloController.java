package com.robin.sbrestful;

import com.robin.sbrestful.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/9 9:17
 */
@Controller
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
