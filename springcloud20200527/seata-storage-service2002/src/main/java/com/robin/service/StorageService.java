package com.robin.service;

/**
 * @Description
 * @Author Robin
 * @Date 2020/6/7 17:15
 */
public interface StorageService {
    //扣减库存
    void decrease(Long productId, Integer count);

}
