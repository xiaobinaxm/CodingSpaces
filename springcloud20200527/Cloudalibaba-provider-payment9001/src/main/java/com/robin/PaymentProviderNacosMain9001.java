package com.robin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description
 * @Author Robin
 * @Date 2020/6/2 14:29
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentProviderNacosMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentProviderNacosMain9001.class, args);
    }
}
