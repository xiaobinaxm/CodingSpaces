package com.robin.service;

import com.robin.entities.CommonResult;
import com.robin.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author Robin
 * @Date 2020/6/7 8:30
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(4444,"服务降级返回,------PaymentFallbackService",new Payment(id,"error serial"));
    }
}
