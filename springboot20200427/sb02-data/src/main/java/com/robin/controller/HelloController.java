package com.robin.controller;

import com.robin.mapper.UserMapper;
import com.robin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/30 10:45
 */
@RestController
public class HelloController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/getUser")
    public List<User> queryUserList() {
        List<User> userList = userMapper.queryUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        return userList;
    }





/*
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/hello")
    public Map<String,Object> map(){

        List<Map<String,Object>> list = jdbcTemplate.queryForList("select * from user");
        return list.get(0);
    }
*/


}
