package com.robin.sborderserviceconsumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableDubbo    //开启基于注解的dubbo
@SpringBootApplication
public class SbOrderServiceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbOrderServiceConsumerApplication.class, args);
    }

}
