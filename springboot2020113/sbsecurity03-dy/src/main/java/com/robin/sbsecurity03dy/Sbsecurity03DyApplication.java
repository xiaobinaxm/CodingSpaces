package com.robin.sbsecurity03dy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.robin.sbsecurity03dy.mapper")
public class Sbsecurity03DyApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sbsecurity03DyApplication.class, args);
    }

}
