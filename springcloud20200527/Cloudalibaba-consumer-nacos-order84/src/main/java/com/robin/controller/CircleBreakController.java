package com.robin.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.robin.entities.CommonResult;
import com.robin.entities.Payment;
import com.robin.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description
 * @Author Robin
 * @Date 2020/6/6 17:41
 */
@RestController
@Slf4j
public class CircleBreakController {

    public static final String SERVER_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;


    //fallback管理运行异常
    //blockHandler管配置违规
    @GetMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")//没有配置
//    @SentinelResource(value = "fallback",fallback = "handlerFallback")//fallback只负责业务异常
//    @SentinelResource(value = "fallback",blockHandler = "blockHandler")//blockHandler只负责sentinel控制台配置违规
//    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler")
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler",exceptionsToIgnore = {IllegalArgumentException.class})
//    public CommonResult<Payment> fallback(@PathVariable Long id) {
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) {

        log.info("-------代码过来了么....----");
        CommonResult<Payment> result = restTemplate.getForObject(SERVER_URL + "/paymentSQL/" + id, CommonResult.class, id);
        log.info("=============牛不牛。。。。");
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常.....");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应的记录，空指针异常");
        }

        return result;
    }

    /**
     * 结论：若blockHandler和fallback都进行了配置，则被限流降级而抛出BlockException时只会进入blockHandler处理逻辑。
     */
    //本例是fallback
    public CommonResult handlerFallback(@PathVariable("id") Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult(444, "兜底异常handlerFallback,exception内容 " + e.getMessage(), payment);
    }


    //本例是blockHandler
    public CommonResult blockHandler(@PathVariable Long id, BlockException blockException) {
        Payment payment = new Payment(id, "null");
        return new CommonResult(445, "blockHandler-sentinel限流，无此流水:blockHandler " + blockException.getMessage(),payment);
    }




    ////==============采用OpenFeign作为服务调用

    @Resource
    private PaymentService paymentService;


    @GetMapping("/consumer/openFeign/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id")Long id) {
        return paymentService.paymentSQL(id);
    }

}
