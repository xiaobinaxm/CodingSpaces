package com.robin.dao;

import com.robin.bean.UserAddress;

import java.util.List;

/**
 * @Description 用户服务接口
 * @Author Robin
 * @Date 2020/4/17 16:59
 */
public interface UserService {
    //按照用户ID返回所有的收货地址
    public List<UserAddress> getUserAddressList(String userId);
}
