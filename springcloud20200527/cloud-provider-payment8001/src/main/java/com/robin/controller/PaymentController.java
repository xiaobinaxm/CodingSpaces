package com.robin.controller;

import com.robin.entities.CommonResult;
import com.robin.entities.Payment;
import com.robin.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author Robin
 * @Date 2020/5/27 15:01
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

//    将服务暴露出去
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
//    public CommonResult create(Payment payment) { 这里必须加上@requestBdy，否则会造成数据丢失
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("********插入结果："+ result);

        if (result > 0) {
            return new CommonResult(200, "插入数据成功,serverPort:" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据失败", null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("********查询结果："+ payment);

        if (payment != null) {
            return new CommonResult(200, "查询成功,serverPort:" + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录，查询ID：" + id, null);
        }
    }


    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        log.info("获取服务名称方法一：");
        for (String service : services) {
            log.info("************service:" + service);
        }

        log.info("获取服务实例方法二：");
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }

        return this.discoveryClient;

    }

    @GetMapping("/payment/lb")
    public String getPaymentId() {
        return serverPort;
    }


    //测试openFeign超时控制   ribbon默认时间是1秒钟
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout() {
        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return serverPort;
    }


    //===================zipkin
    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return "hi,I am paymentZipkin server fallback,welcome to helloWorld,o(∩_∩)o 哈哈";
    }


}
