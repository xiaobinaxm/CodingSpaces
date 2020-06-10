package com.robin.controller;

import com.robin.domain.CommonResult;
import com.robin.domain.Order;
import com.robin.service.IdGeneratorSnowflake;
import com.robin.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description
 * @Author Robin
 * @Date 2020/6/7 16:00
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @Resource
    private IdGeneratorSnowflake idGeneratorSnowflake;

    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功!!!");
    }



    //生成id,通过雪花算法
    @GetMapping("/snowflake")
    public String getIDBySnowflake() {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            threadPool.submit(() -> {
                System.out.println(idGeneratorSnowflake.snowflakeId());
            });
        }
        threadPool.shutdown();
        return "hello snowflake";
    }


}
