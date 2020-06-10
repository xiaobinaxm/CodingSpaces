package com.robin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Robin
 * @Date 2020/6/2 14:52
 */
@RestController
@Slf4j
public class PaymentProviderNacosController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        log.info("**********serverPort: " + serverPort);
        log.info("**********id: " + id);
        return "Nacos registory, serverPort: " + serverPort + "\t" + "id: " + id;
    }

}
