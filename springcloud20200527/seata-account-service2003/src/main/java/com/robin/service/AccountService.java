package com.robin.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Description
 * @Author Robin
 * @Date 2020/6/7 17:29
 */
public interface AccountService {
    //扣减账户余额
    void decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
