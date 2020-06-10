package com.robin.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.robin.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author Robin
 * @Date 2020/5/31 18:05
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String paymentInfo_ok = paymentHystrixService.paymentInfo_OK(id);
        log.info("***********paymentInfo_ok: " + paymentInfo_ok);
        return paymentInfo_ok;
    }

//    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
//        String paymentInfoTimeOut = paymentHystrixService.paymentInfo_TimeOut(id);
//        log.info("**********paymentInfoTimeOut: " + paymentInfoTimeOut);
//        return paymentInfoTimeOut;
//    }



//    //演示容错机制  容错降级
//    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
//    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
//        String paymentInfoTimeOut = paymentHystrixService.paymentInfo_TimeOut(id);
//        log.info("**********paymentInfoTimeOut: " + paymentInfoTimeOut);
//        return paymentInfoTimeOut;
//    }
//
//    public String paymentInfo_TimeOutHandler(Integer id) {
//        return "我是消费者80，对方支付系统繁忙，请在10秒钟后再试或者自己运行错误请检查，(┬＿┬)";
//    }


//    解决代码膨胀问题
    //演示容错机制  容错降级
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand     //加了@DefaultProperties属性注解，并且没有写具体的方法名字，就用全局统一的
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String paymentInfoTimeOut = paymentHystrixService.paymentInfo_TimeOut(id);
        log.info("**********paymentInfoTimeOut: " + paymentInfoTimeOut);
        return paymentInfoTimeOut;
    }

    //这个是全局fallback方法
    public String payment_Global_FallbackMethod() {
        return "Global异常处理信息，请稍后重试，(┬＿┬)::>_<::";
    }
}
