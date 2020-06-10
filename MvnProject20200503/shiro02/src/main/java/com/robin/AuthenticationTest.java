package com.robin;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;
import org.junit.validator.PublicClassValidator;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/22 22:52
 */
public class AuthenticationTest {

    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    //开始方法，添加一个用户
    @Before
    public void addUser() {
        simpleAccountRealm.addAccount("admin","root");
    }

    @Before
    public void addUser1() {
        simpleAccountRealm.addAccount("root","root","user","root");
    }


    @Test
    public void test() {
        //构建securityManager环境
        DefaultSecurityManager manager = new DefaultSecurityManager();
        manager.setRealm(simpleAccountRealm);

        //主体提交认证请求
        SecurityUtils.setSecurityManager(manager);//设置securityManager环境
        Subject subject = SecurityUtils.getSubject();//获取当前主体

        UsernamePasswordToken token = new UsernamePasswordToken("admin", "root");
        subject.login(token);//登陆

        boolean authenticated = subject.isAuthenticated();
        System.out.println("登陆之前的authenticated：>>>>>" + authenticated);//true

        subject.logout();

        boolean authenticated1 = subject.isAuthenticated();
        System.out.println("登出之后的authenticated：>>>" + authenticated1);//false
    }


    @Test
    public void test1() {
        DefaultSecurityManager manager = new DefaultSecurityManager();
        manager.setRealm(simpleAccountRealm);

        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("root", "root");
        subject.login(token);

        boolean authenticated = subject.isAuthenticated();
        System.out.println("登陆之前的authenticated：>>>>>" + authenticated);//true

        // 判断subject是否具有root和user两个角色权限,如没有则会报错
        subject.checkRoles("root","user");
        //subject.checkRoles("xxxx");//Subject does not have role [xxxx]


    }
}
