package com.robin;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/23 0:05
 */
public class CodingTest {

    @Test
    public void test() {
        //实现自己的realm
        FirstShiroRealm firstShiroRealm = new FirstShiroRealm();

        //构建securityManager
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(firstShiroRealm);

        //主体提交认证请求
        SecurityUtils.setSecurityManager(securityManager);
        //获取用户
        Subject subject = SecurityUtils.getSubject();

        //包装
        UsernamePasswordToken token = new UsernamePasswordToken("root", "root");
        subject.login(token);
        
        //验证是否登录成功
        boolean authenticated = subject.isAuthenticated();
        System.out.println("authenticated》》》》》》" + authenticated);

        subject.checkRoles("admin","user");

        subject.checkPermission("user:add");


    }
}
