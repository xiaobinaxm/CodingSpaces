package com.robin.config;

import com.robin.pojo.User;
import com.robin.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description 自定义UserRealm 继承制AuthorizingRealm
 *              注意顺序：先认证，后授权
 * @Author Robin
 * @Date 2020/5/1 0:12
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("doGetAuthorizationInfo>>>>>授权");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //设置一下，所有用户登陆进来都有这个权限,这个写死了
        //info.addStringPermission("user:add");
        //拿到当前登陆后的这个用户对象
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();

        //设置当前用户的权限
        //如果加这一句话：则需要设计数据库字段：String perms 值为：user:add   user:update   ......
        //实际开发中一般不用这种的
        info.addStringPermission(currentUser.getPerms());

        return info;
    }


    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("doGetAuthenticationInfo>>>>>>>认证");

        //此处应该也的是登陆认证的第一步信息，为了便于理解，我将代码写到ShiroController类中
        //com.robin.controller.ShiroController

//        //用户名  密码   数据重合而来，数据库呀~~~~
//        String name = "admin";
//        String password = "123456";

        //前端页面传递过来的用户名  密码，通过Token获取后，名称叫法发生了变化
        //用户名：principal     密码：credentials
        UsernamePasswordToken userToken = (UsernamePasswordToken)token;
        String principal = (String) userToken.getPrincipal();
        Object credentials = userToken.getCredentials();

//        //用户名认证
//        if (!userToken.getPrincipal().equals(name)) {
//            return null;
//        }


        //开始连接真实数据库
        User user = userService.getUserByName(principal);
        if (user == null) {
            return null;
        }
        //密码认证，Shiro来做，安全性比较高


        //注意这个方法SimpleAuthenticationInfo，所有参数使用的Object类型，所有前面获取参数的时候，不要转成S同日给你类型
        //报错后，看不明白错误原因，一定要看源码
//        return new SimpleAuthenticationInfo("",credentials,"");
        return new SimpleAuthenticationInfo(principal,credentials,"");
    }
}
