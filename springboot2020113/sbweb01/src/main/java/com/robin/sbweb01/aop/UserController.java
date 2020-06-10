package com.robin.sbweb01.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/7 22:49
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/aop1")
    public String getNameById(Integer id){
        return userService.getNameById(id);
    }

    @GetMapping("/aop2")
    public void delNameById(Integer id){
        userService.delNameById(id);
    }
}
