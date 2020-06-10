package com.robin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description
 * @Author Robin
 * @Date 2020/6/2 16:33
 */
@RestController
@Slf4j
public class OrderNacosController {

    //这个是以前的解决方案，我们这里采用的是冲配置文件中按到服务名称，利于后期维护
    //public static final String SERVER_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;


    @GetMapping("/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Integer id) {
        log.info("*************serverUrl: " + serverUrl + "\t" + "id: " + "\t" + id);
        return restTemplate.getForObject(serverUrl + "/payment/nacos/" + id, String.class);
    }


}
