package com.robin.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Description 判断是否Windows系统
 * @Author Robin
 * @Date 2018/12/12 0:14
 */
public class WindowsCondition implements Condition {

    /**
     * @Description：判断条件能够使用的上下文环境
     *              AnnotatedTypeMetadata：注释信息
     * @Author:Robin
     * @Date:2018/12/12 0:17
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //判断是否是Windows系统
        //1、获取到ioc容器中的beanfactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //2、获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        //3、获取当前的环境信息
        Environment environment = context.getEnvironment();
        //获取bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();

        String property = environment.getProperty("os.name");
        if(property.contains("Windows")){
            return true;
        }

        return false;
    }
}
