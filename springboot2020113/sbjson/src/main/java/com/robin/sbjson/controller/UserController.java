package com.robin.sbjson.controller;

import com.robin.sbjson.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/4 23:45
 */
@Controller
public class UserController {

    @ResponseBody
    @GetMapping("/user")
    public List<User> getAllUser(){
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i);
            user.setUsername("robin>>>"+i);
            user.setAddress("com.robin>>>"+i);

            user.setBirthday(new Date());
            users.add(user);

        }
        return users;
    }
}
