package com.robin.service;


import com.robin.bean.UserAddress;
import com.robin.dao.OrderService;
import com.robin.dao.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 1.将服务提供者注册到注册中心（暴露服务）
 *                  1）导入dubbo依赖(2.6.2)/操作zookeeper的客户端（curator）
 *                  2）配置服务提供者
 *              2.让消费者去注册中心订阅服务提供者的服务地址
 * @Author Robin
 * @Date 2020/4/17 17:13
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    UserService userService;
    public void initOrder(String userID) {
        System.out.println("用户ID：" + userID);
        //1、查询用户的收货地址
        List<UserAddress> list = userService.getUserAddressList(userID);
        for (UserAddress userAddress : list) {
            System.out.println(userAddress.getUserAddress());
        }
        System.out.println(list);
    }
}
