package com.robin.config;

import com.robin.bean.Car;
import com.sun.org.apache.xml.internal.security.Init;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Description bean的生命周期
 *              bean创建----初始化---销毁
 *              容器帮助我们管理bean的生命力周期
 *              我们可以自定义初始化和销毁方法；容器在bean进行到当前生命周期来调用我们自定义的初始化和销毁方法的饿时候
 *
 *             构造器（对象创建）
 *              单实例：在容器启动的时候创建对象
 *              多实例：在每次获取的时候，获取对象
 *
 *初始化：
 *      对象创建完成，并赋值好，调用初始化方法
 * 销毁：
 *      单实例：容器关闭后
 *      多实例：容器不会销毁，需要自己主动去调用销毁方法
 *
 *             1）指定初始化和销毁方法；
 *                  通过@bean指定init_method方法和的story-method方法
 *
 *
 * @Author Robin
 * @Date 2018/12/23 11:34
 */
@Configuration
public class MainConfigOfLifeCycle {

    @Scope
    @Bean(initMethod = "init",destroyMethod = "destory")
    public Car car(){
        return  new Car();
    }
}
