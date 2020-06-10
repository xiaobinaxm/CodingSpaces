package com.robin.sbpersistent;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(basePackages = "com.robin.sbpersistent.mybatis")
public class SbpersistentApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbpersistentApplication.class, args);
    }

}
