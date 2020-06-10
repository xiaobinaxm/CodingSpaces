package com.robin.freemarker.controller;

import com.robin.freemarker.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/4 17:22
 */
@Controller
public class UserController {

    @GetMapping("/user")
    public String user(Model model) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId((long) i);
            user.setUsername("robin>>>" + i);
            user.setAddress("com.robin.springboot>>>" + i);
            users.add(user);
        }
        model.addAttribute("users", users);
        return "user";
    }

}
