package com.robin.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author Robin
 * @Date 2020/5/31 12:36
 */
@Configuration
public class OpenFeignConfig {

    //设置openfeign的日志打印级别
    //特别要注意这个包  import feign.Logger;
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
