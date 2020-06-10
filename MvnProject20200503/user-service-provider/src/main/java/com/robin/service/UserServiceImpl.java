package com.robin.service;

import com.robin.bean.UserAddress;
import com.robin.dao.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/17 17:01
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        UserAddress userAddress1 = new UserAddress(1, "北京海淀区", "1", "李老师", "18888888888", "Y");
        UserAddress userAddress2 = new UserAddress(2, "北京西城区", "1", "19999999999", "胡老师", "N");
        return Arrays.asList(userAddress1, userAddress2);
    }
}
