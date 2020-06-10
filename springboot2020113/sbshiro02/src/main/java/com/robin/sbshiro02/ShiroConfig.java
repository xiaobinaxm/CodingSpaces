package com.robin.sbshiro02;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.TextConfigurationRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/11 22:06
 */
@Configuration
public class ShiroConfig {

    @Bean
    Realm realm() {
        TextConfigurationRealm realm = new TextConfigurationRealm();
        //设置用户名密码以及对应的角色
        realm.setUserDefinitions("robin=root,user \n admin=root,admin");
        //设置每种角色的权限
        realm.setRoleDefinitions("admin=read,write \n user=read");
        return realm;
    }

    //配置过滤规则
    @Bean
    ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition definition = new DefaultShiroFilterChainDefinition();
        definition.addPathDefinition("/doLogin", "anon");
        definition.addPathDefinition("/**", "authc");
        return definition;
    }


}
