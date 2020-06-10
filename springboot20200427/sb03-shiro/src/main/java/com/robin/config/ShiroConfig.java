package com.robin.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description
 * @Author Robin
 * @Date 2020/5/1 0:00
 */
@Configuration
public class ShiroConfig {

    //ShiroFilterFactoryBean    此处方法命名必须是shiroFilterFactoryBean，否则报错
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //设置shiro的内置过滤器
        Map<String, String> fileMap = new LinkedHashMap<>();
        fileMap.put("/add", "authc");
        fileMap.put("/update", "authc");

        //授权
        fileMap.put("/add", "perms[user:add]");

        bean.setFilterChainDefinitionMap(fileMap);
        //设置登陆页面，自定义login页面
        bean.setLoginUrl("/toLogin");

        //为授权页面
        bean.setUnauthorizedUrl("/noauth");



        return bean;
    }

    //DefaultWebSecurityManager
    @Bean(name = "securityManager") //可以采用别名的方式，很方便的
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联userRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //创建Realm对象，需要自定义
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

}
