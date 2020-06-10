package com.robin.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author Robin
 * @Date 2020/6/4 21:22
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "=================testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "=================testB";
    }


    @GetMapping("/testD")
    public String testD() {
        //暂停几秒钟线程
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        log.info("---------testD 测试RT");


        log.info("----------testD，测试异常比例");
        int age = 10/0;
        return "------------testD";
    }

    @GetMapping("/testE")
    public String testE() {
        log.info("----------teste，测试异常数");
        int age = 10/0;
        return "=================testB";
    }


    //热点规则
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "---------testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException e) {
        return "------------deal_testHotKey,(┬＿┬)";//sentinel系统默认的提示: Blocked by Sentinel (flow l imiting)
    }

//    所以熔断和流控的区别是啥，感觉目的都是保护系统
//    流控是根据访问量来判断是否拒绝，熔断是根据系统报错是否拒绝
//    流量控制是外部请求的压力，熔断是业务出错不影响整个微服务的运行


}
