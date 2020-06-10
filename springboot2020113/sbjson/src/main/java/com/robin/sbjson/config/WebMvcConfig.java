package com.robin.sbjson.config;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/5 20:57
 */
@Configuration
public class WebMvcConfig {

//    //Gson这一块一直有问题，没有解决，具体问题开发中在解决吧
//    @Bean
//    GsonHttpMessageConverter gsonHttpMessageConverter(){
//        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
//        converter.setGson(new GsonBuilder().setDateFormate("yyyy-MM-dd").create());
//        return converter;
//    }
//
//    @Bean
//    Gson gson(){
//        return new GsonBuilder().setDateFormate("yyyy-MM-dd").create();
//    }

    //配置fastjson转换
    @Bean
    FastJsonHttpMessageConverter fastJsonHttpMessageConverter(){
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setDateFormat("yyyy-MM-dd");
        converter.setFastJsonConfig(config);
        return converter;
    }
}
