package com.robin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description
 * @Author Robin
 * @Date 2020/6/6 17:18
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentProviderNacosMain9004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentProviderNacosMain9004.class, args);
    }
}
