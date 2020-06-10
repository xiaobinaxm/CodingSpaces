package com.robin.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author Robin
 * @Date 2020/5/31 16:53
 */
@Service
public class PaymentHystrixService {

    //============================服务降级Fallback==================================
    //成功
    public String paymentInfo_OK(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + " paymentInfo_OK,id: " + id + "\t" + "o(∩_∩)o 哈哈";
    }


//    //超时情况
//    public String paymentInfo_TimeOut(Integer id) {
//        Integer timeNumber = 3;
//        //暂停几秒钟线程
//        try {
//            TimeUnit.SECONDS.sleep(timeNumber);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return "线程池： " + Thread.currentThread().getName() + " paymentInfo_TimeOut,id: " + id + "\t" + "o(∩_∩)o 哈哈" + "\t" + "耗时" + timeNumber + "秒钟";
//    }

    //超时情况
    //服务降级      服务出现卡死等情况后，开始适用这个方法paymentInfo_TimeOutHandler
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            //这个注解的意思是，我们规定3秒钟以内是正常的
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        Integer timeNumber = 3;
//        int x = 10/0;
        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() + " paymentInfo_TimeOut,id: " + id + "\t" + "o(∩_∩)o 哈哈" + "\t" + "耗时" + timeNumber + "秒钟";
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + " paymentInfo_TimeOutHandler,系统繁忙或报错，请稍后再试,id: " + id + "\t" + "哭(┬＿┬)";
    }


    //=======================服务熔断break===========================
//    涉及到断路器的三个重要参数:快照时间窗、请求总数阀值、错误百分比阀值。
//        1:快照时间窗:断路器确定是否打开需要统计-些请求和错误数据, 而统计的时间范围就是快照时间窗,默认为最近的10秒。
//        2:请求总数阀值:在快照时间窗内，必须满足请求总数阀值才有资格熔断。默认为20， 意味着在10秒内,如果该hystrix命令
//            的调用次数不足20次,即使所有的请求都超时或其他原因失败，断路器都不会打开。
//        3:错误百分比阀值:当请求总数在快照时间窗内超过了阀值,比如发生了30次调用，如果在这30次调用中，有15次发生了超时异常，
//            也就是超过50%的错误百分比，在默认设定50%阀值情况下，这时候就会将断路器打开。

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器，请求次数达到峰值后，断路器状态会从关闭状态转换为打开状态
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口(统计时间依据最近的10秒钟为准)
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("******id不能是负数");
        }
        //采用的是hutool工具类，会使用即可，国人写的，还是很牛X的
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号是： " + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "ID 不能是负数，请稍后重试，(┬＿┬) id: " + id;
    }




}
