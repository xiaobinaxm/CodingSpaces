package com.robin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description
 * @Author Robin
 * @Date 2020/6/2 16:22
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsumerNacosMain83 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsumerNacosMain83.class, args);
    }
}
