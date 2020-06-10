package com.robin.service;

import com.robin.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Description
 * @Author Robin
 * @Date 2020/5/27 14:55
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
