package com.robin.sborderserviceconsumer.controller;

import com.robin.bean.UserAddress;
import com.robin.dao.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.StreamSupport;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/18 18:07
 */
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;
    @RequestMapping("/initOrder")
    @ResponseBody
    public List<UserAddress> sbInitOrder(@RequestParam("uid")String userId) {

        String string = new String();
        String string1 = new String();
        String string2 = new String();
        String string3 = new String();



        return orderService.sbInitOrder(userId);
    }



}
