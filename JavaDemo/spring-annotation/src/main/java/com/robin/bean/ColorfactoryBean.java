package com.robin.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Description 创建一个spring定义的FactoryBean
 * @Author Robin
 * @Date 2018/12/16 21:10
 */
public class ColorfactoryBean implements FactoryBean<Color> {
    @Override
    //返回一个、color对象，这个对象会添加到容器中
    public Color getObject() throws Exception {
        System.out.println("ColorfactoryBean。。。。。");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    @Override
    //控制是否单例
    //true：是单实例，容器中只保存一份
    //false：多实例，每次调用时候，都创建一份
    public boolean isSingleton() {
        return false;
    }
}
