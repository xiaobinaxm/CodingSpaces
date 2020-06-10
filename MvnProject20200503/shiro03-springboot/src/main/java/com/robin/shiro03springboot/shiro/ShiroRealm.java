package com.robin.shiro03springboot.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/24 15:12
 */
public class ShiroRealm extends AuthorizingRealm {

    @Resource
    private SysUserService sysUserService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //程序进入到这一步，说明用户已经通过验证
        SysUser sysUser = (SysUser) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (SysRole role : sysUser.getRoles()) {
            info.addRole(role.getName());
            for (SysPermission permission : role.getPermissions()) {
                info.addStringPermission(permission.getName());
            }
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //获取用户名
        String username = (String) token.getPrincipal();
        System.out.println("token.getPrincipal()>>>>>>" + token.getPrincipal());
        //通过username从数据库中查询SysUser对象
        SysUser sysUser = sysUserService.getSysUserByUserName(username);
        if (sysUser == null) {
            return null;
        }
        Object principal;
        Object hashedCredentials;
        ByteSource credentialsSalt;
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                username, //用户名
                sysUser.getPassword(),//密码
                ByteSource.Util.bytes(sysUser.getSalt()), //salt=usernaem+salt
                getName());


        return simpleAuthenticationInfo;
    }
}
