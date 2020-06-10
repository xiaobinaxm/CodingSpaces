package com.robin.sbweb01.aop;

import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/7 19:21
 */
@Service
public class UserService {

    public String getNameById(Integer id){
        System.out.println("getNameById....");
        return "robin";
    }

    public void delNameById(Integer id){
        System.out.println("delNameById.....");
    }
}
