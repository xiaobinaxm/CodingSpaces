package com.robin.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author Robin
 * @Date 2020/5/27 17:06
 */
@Configuration
public class ApplicationContextConfig {


    @Bean
    @LoadBalanced   //使用@LoadBalanced注解赋予RestTemplilate负载均衡的能力
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
