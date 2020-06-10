package com.robin.service;

import com.robin.mapper.UserMapper;
import com.robin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author Robin
 * @Date 2020/5/1 21:53
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }
}
