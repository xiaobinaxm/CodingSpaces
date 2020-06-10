package com.robin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description
 * @Author Robin
 * @Date 2020/6/4 21:21
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosSentinelServiceMain8401 {
    public static void main(String[] args) {
        SpringApplication.run(NacosSentinelServiceMain8401.class, args);
    }
}
