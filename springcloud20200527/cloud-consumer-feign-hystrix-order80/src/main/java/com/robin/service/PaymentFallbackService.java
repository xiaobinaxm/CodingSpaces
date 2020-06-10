package com.robin.service;

import org.springframework.stereotype.Component;

/**
 * @Description 服务端挂掉之后，客户端继续访问后，做的相应处理
 * @Author Robin
 * @Date 2020/5/31 19:30
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----------PaymentFallbackService------paymentInfo_OK,(┬＿┬)::>_<::";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----------PaymentFallbackService--------paymentInfo_TimeOut，(┬＿┬)::>_<::";
    }
}
