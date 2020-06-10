package com.robin.condition;

import com.robin.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Description
 * @Author Robin
 * @Date 2018/12/16 16:37
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    //AnnotationMetadata：当前类的注解信息
    //BeanDefinitionRegistry：BeanDefination的注册类
        //把所有需要添加到容器中的bean；注册进来         就是自定义注册进来
    // BeanDefinitionRegistry.registryBeanDefinition    手工注册进来
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

//        boolean red = registry.containsBeanDefinition("red");
//        boolean blue = registry.containsBeanDefinition("blue");
        boolean red = registry.containsBeanDefinition("com.robin.bean.Red");
        boolean blue = registry.containsBeanDefinition("com.robin.bean.Blue");
        //指定bean名
        if (red && blue){
            //指定bean的定义信息，就是bean的类型
            RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
            //注册一个bean
            registry.registerBeanDefinition("rainBow",beanDefinition);
        }
    }
}
