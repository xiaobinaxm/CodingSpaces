package com.robin.sbweb01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.robin.sbweb01")
public class Sbweb01Application {

    public static void main(String[] args) {
        SpringApplication.run(Sbweb01Application.class, args);
    }

}
