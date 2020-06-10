package com.robin.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.robin.entities.CommonResult;

/**
 * @Description
 * @Author Robin
 * @Date 2020/6/6 16:58
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException e) {
        return new CommonResult(444, "按照客户自定义，Global handlerException-------1");
    }

     public static CommonResult handlerException2(BlockException e) {
        return new CommonResult(444, "按照客户自定义，Global handlerException-------2");
    }





}
