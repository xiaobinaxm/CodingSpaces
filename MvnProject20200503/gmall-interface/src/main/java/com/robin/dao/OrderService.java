package com.robin.dao;

import com.robin.bean.UserAddress;

import java.util.List;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/17 17:12
 */
public interface OrderService {
    //初始化订单
    public void initOrder(String userID);

    //SpringBoot初始化订单
    public List<UserAddress> sbInitOrder(String userID);

}
