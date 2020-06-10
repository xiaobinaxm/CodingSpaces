package com.robin.service;

import com.robin.entities.CommonResult;
import com.robin.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description
 * @Author Robin
 * @Date 2020/5/31 11:23
 */
@Component  //接口的地方一定要加上这个注解
@FeignClient("CLOUD-PAYMENT-SERVICE")   //调用接口服务，看看调用的是那个服务，需要自己指明
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    //测试openFeign超时控制
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout();
}
