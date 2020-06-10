package com.robin.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
//import com.baomidou.mybatisplus.mapper.ISqlInjector;
//import com.baomidou.mybatisplus.mapper.LogicSqlInjector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/25 19:00
 */
@MapperScan("com.robin.mapper")//扫描我们的mapper文件夹
@EnableTransactionManagement
@Configuration
public class MyBatisPlusConfig {

    //注册我们的乐观锁
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    //MyBatis-plus的分页插件，下面演示的是最基本的插件，
    //使用的时候，直接配置注入bean，然后直接使用Page对象即可
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    //mybatis-plus3.3.0之后不再支持这种用法了，直接配置在配置文件中即可，不用注册到context容器中了
    //逻辑删除
//    @Bean
//    public ISqlInjector iSqlInjector() {
//        return new LogicSqlInjector();
//    }

/*
    //该插件 3.2.0 以上版本移除
    @Bean
    @Profile({"dev","test"})// 设置 dev test 环境开启
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }
*/

/*
    //SQL执行效率插件    3.2.1版本之后可以用，高版本不行
    @Bean
    @Profile({"dev", "test"})// 设置 dev test 环境开启，保证我们的效率
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setMaxTime(100); // ms设置sql执行的最大时间，如果超过了则不执行
        performanceInterceptor.setFormat(true); // 是否格式化代码
        return performanceInterceptor;
    }
*/

}
