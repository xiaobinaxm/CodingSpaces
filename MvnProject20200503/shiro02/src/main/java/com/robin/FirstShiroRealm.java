package com.robin;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/22 23:22
 */

public class FirstShiroRealm extends AuthorizingRealm {

    //模拟数据库用户
    HashMap<String ,String> userMap = new HashMap<String, String>();
    {
        userMap.put("root", "root");
        super.setName("firstShiroRealm");
    }

    //模拟从数据库中，通过用户名获取密码（凭证）
    public String getPwdByUserName(String username) {
        return userMap.get(username);
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //从主体穿过来的认证信息，，获取用户名
        String username = (String) token.getPrincipal();
        //模拟通过用户名从数据库中获取凭证
        String password = getPwdByUserName(username);
        if (password == null) {
            return null;
        }
        //简单形式的无加密
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo("root", password, "firstShiroRealm");
        return info;
    }

    //模拟从数据库中获取用户权限
    public Set<String> getPermissionsByUserName(String username) {
        Set<String> permission = new HashSet<String>();
        permission.add("user:add");
        permission.add("user:delete");
        return permission;
    }

    //模拟从数据库中获取用户角色
    public Set<String> getRolesByUserName(String username) {
        Set<String> roles = new HashSet<String>();
        roles.add("admin");
        roles.add("root");
        roles.add("user");
        return roles;
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        //依据用户名从数据库中获取角色和权限】
        Set<String> permissions = getPermissionsByUserName(username);
        Set<String> roles = getRolesByUserName(username);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permissions);
        info.setRoles(roles);
        return info;
    }

}
