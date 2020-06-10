package com.robin.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description
 * @Author Robin
 * @Date 2020/5/30 9:18
 */
@RestController
@Slf4j
public class OrderConsulController {

    public static final String INVOKE_CONSUL_URL = "http://consul-provider-payment/";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/consul")
    public String paymentConsulInfo() {
        String result = restTemplate.getForObject(INVOKE_CONSUL_URL + "payment/consul", String.class);

        return result;
    }
}
