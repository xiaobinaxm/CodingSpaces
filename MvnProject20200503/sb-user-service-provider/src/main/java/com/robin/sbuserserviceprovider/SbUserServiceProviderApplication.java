package com.robin.sbuserserviceprovider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @Description：1.导入依赖
 *                  1）、导入duboo-starter
 *                  2）、导入dubbo的其他依赖
 * @Author:Robin
 * @Date:2020/4/18 20:46
 */
//@EnableDubbo//开启基于注解的dubbo功能，以前的版本是com.alibaba....
@EnableDubbo    //开启基于注解的dubbo,现在都是统一到org.apache.....
@SpringBootApplication
public class SbUserServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbUserServiceProviderApplication.class, args);
    }

}
