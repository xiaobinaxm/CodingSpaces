package com.robin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description
 * @Author Robin
 * @Date 2020/5/30 8:54
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsulMain {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsulMain.class, args);
    }
}
