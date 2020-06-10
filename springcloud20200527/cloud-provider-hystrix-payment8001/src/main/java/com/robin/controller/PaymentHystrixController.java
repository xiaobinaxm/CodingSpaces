package com.robin.controller;

import com.robin.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author Robin
 * @Date 2020/5/31 17:00
 */
@RestController
@Slf4j
public class PaymentHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    //对外暴露出我们的服务端口
    @Value("${server.port}")
    private String serverPort;

    //============================服务降级Fallback==================================

    //对外暴露出我们的服务地址
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_OK(id);
        log.info("*******result: " + result);
        return result;
    }

    //对外暴露出我们的服务地址
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        log.info("****result: " + result);
        return result;
    }



    //=======================服务熔断break===========================
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String paymentCircuitBreaker = paymentHystrixService.paymentCircuitBreaker(id);
        log.info("**********paymentCircuitBreaker: " + paymentCircuitBreaker);
        return paymentCircuitBreaker;
    }

}
