package com.robin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.robin.mapper")
public class Sb02DataApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sb02DataApplication.class, args);
    }

}
