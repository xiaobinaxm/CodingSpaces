package com.robin.realms;

import com.robin.MD5Utils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashSet;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/20 22:23
 */
public class ShiroRealm extends AuthorizingRealm {

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        //不设置用户名的时候
        //String username = usernamePasswordToken.getUsername();
        //获取用户名去判断密码
        String username = (String) usernamePasswordToken.getPrincipal();
        System.out.println("从数据库中获取username：>>>>" + username + "所有对应的信息");
        if ("unknown".equals(username)) {
            throw new UnknownAccountException("用户不存在！");
        }
        if ("monster".equals(username)) {
            throw new LockedAccountException("用户被锁定");
        }

        //非加密形式
//        Object principl = username;
//        Object credentials = "123456";
//        String realName = getName();
//        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principl, credentials, realName);
//        System.out.println("doGetAuthenticationInfo" + token);

        //密码，此处直接写死
        String password = "123456";
        String credentials = MD5Utils.encryption(username,password);
        System.out.println("加密之后的密码：>>>>" + credentials);
        //设置盐值
        ByteSource salt = ByteSource.Util.bytes(username);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, credentials, salt, getName());

        return info;
/*
        // 获取用户名去判断密码
        Object username = token.getPrincipal();
        // 先不连接数据库 先写死密码
        String password = MD5Utils.encryption("123456");
        // 返回封装的数据
        // SimpleAuthenticationInfo saci = new SimpleAuthenticationInfo(username, password, getName());
        // 返回加密封装后数据
        // 设置盐值
//        ByteSource salt = ByteSource.Util.bytes(username);
        ByteSource salt = ByteSource.Util.bytes("123456");
        SimpleAuthenticationInfo saci = new SimpleAuthenticationInfo(username,password,salt,getName());
        return saci;
*/

    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        Object username = principalCollection.getPrimaryPrincipal();
        if ("admin".equals(username.toString())) {
            HashSet<String> roles = new HashSet<>();
            roles.add("admin");
            info.addRoles(roles);
        } else if ("admin2".equals(username.toString())) {
            HashSet<String> permissions = new HashSet<>();
            permissions.add("user:user");
            info.addStringPermissions(permissions);
        }
        return info;
    }




/*
    public static void main(String[] args) {
        String hashAlgorithmName = "MD5";
        Object credentials = "123456";
        Object salt = ByteSource.Util.bytes("user");
        int hashIterations = 1024;
        Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        System.out.println(result);
    }
*/
}
