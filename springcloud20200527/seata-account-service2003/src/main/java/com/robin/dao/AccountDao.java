package com.robin.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Description
 * @Author Robin
 * @Date 2020/6/7 17:24
 */
@Mapper
public interface AccountDao {
    //扣减账户余额
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
