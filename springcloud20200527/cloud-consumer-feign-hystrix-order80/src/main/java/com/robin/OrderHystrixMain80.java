package com.robin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description
 * @Author Robin
 * @Date 2020/5/31 17:57
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix  //开启Hystrix，内部包含@EnableCircuitBreaker
//@EnableEurekaClient//这里配置文件中，没有注册金Eureka中，所以不需要添加这个注解
public class OrderHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain80.class, args);
    }
}
