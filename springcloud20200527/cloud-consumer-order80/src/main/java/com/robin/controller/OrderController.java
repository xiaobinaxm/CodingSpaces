package com.robin.controller;

import com.robin.entities.CommonResult;
import com.robin.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description
 * @Author Robin
 * @Date 2020/5/27 17:02
 */
@RestController
@Slf4j
public class OrderController {

//    public static final String PAYMENT_URL = "http://localhost:8001";
//    集群版本
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE:8001";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        log.info("consumer order调用provider插入payment=====>>>>" + payment);
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }


    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        log.info("consumer order调用provider通过ID查询payment=====>>>>" + id);
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }


//    以上采用的是getForObject/postForObject,返回来的是json字符串 返回对象为响应体中数据转化成的对象，基本上可以理解为Json
//    下面采用的是getForEntity/psotForEntity，返回的是一个对象 返回对象为ResponseEntity对象，包含了响应中的一些重要信息，比如响应头、响应状态码、响应体等
    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            return forEntity.getBody();
        } else {
            return new CommonResult<>(444, "操作失败");
        }
    }

    @GetMapping("/consumer/payment/getForEntity/create")
    public CommonResult<Payment> create2(Payment payment) {
        log.info("consumer order调用provider插入payment=====>>>>" + payment);
        return restTemplate.postForEntity(PAYMENT_URL+"/payment/create",payment,CommonResult.class).getBody();
    }


    ////==============zipkin+sleuth
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin() {
//        我们后面没有跟ID之类的，没必要多加一个【/】否则容易报错 /payment/zipkin/
//        String result = restTemplate.getForObject(PAYMENT_URL + "/payment/zipkin/", String.class);
        String result = restTemplate.getForObject(PAYMENT_URL + "/payment/zipkin", String.class);
        return result;
    }

}
