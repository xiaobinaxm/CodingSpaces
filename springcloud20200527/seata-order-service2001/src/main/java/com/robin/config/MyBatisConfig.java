package com.robin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author Robin
 * @Date 2020/6/7 16:02
 */
@Configuration
@MapperScan({"com.robin.dao"})
public class MyBatisConfig {
}
