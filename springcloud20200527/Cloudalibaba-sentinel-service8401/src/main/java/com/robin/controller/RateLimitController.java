package com.robin.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.robin.entities.CommonResult;
import com.robin.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Robin
 * @Date 2020/6/6 15:37
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "按照资源名称限流测试OK", new Payment(2020L, "serial001"));
    }

    public CommonResult handleException(BlockException e) {
        return new CommonResult(444, e.getClass().getCanonicalName() + "\t" + "服务不可用");
    }


    @GetMapping("/rateLimit/byURL")
    @SentinelResource(value = "byURL")
    public CommonResult byURL() {
        return new CommonResult(200, "按照URL限流测试OK", new Payment(2020L, "serial002"));
    }



    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
                        blockHandlerClass = CustomerBlockHandler.class,
                        blockHandler = "handlerException2")
    public CommonResult customerBlockHandler() {
        return new CommonResult(200, "按照客户自定义", new Payment(2020L, "serial003"));
    }



}
