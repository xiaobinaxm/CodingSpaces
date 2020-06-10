package com.robin.dao;

import com.robin.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description
 * @Author Robin
 * @Date 2020/6/7 14:59
 */
@Mapper
public interface OrderDao {
    //1.新建订单
    void create(Order order);

    //2.修改订单状态，从0到1
    void update(@Param("userId") Long userId, @Param("status") Integer status);


//    int create(Order order);
//    int update(@Param("userId") Long userId, @Param("status") Integer status);

}
