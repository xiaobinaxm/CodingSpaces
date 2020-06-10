package com.robin.service;

import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author Robin
 * @Date 2020/3/18 0:13
 */
@Service
public class HelloService {
    public String say(){
        return "Hello,this is HelloService,开心😄";
    }
}
