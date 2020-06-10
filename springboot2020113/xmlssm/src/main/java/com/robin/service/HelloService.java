package com.robin.service;

import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author Robin
 * @Date 2020/1/14 0:35
 */
@Service
public class HelloService {
    public String sayHello() {
        return "hello SpringBoot,我来了，我们开始学习了！";
    }
}
