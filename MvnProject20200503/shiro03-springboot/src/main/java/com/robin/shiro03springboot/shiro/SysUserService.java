package com.robin.shiro03springboot.shiro;

import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/24 15:07
 */
@Service
public interface SysUserService {
    /**
     * @Description：通过用户名查询用户信息
     * @Author:Robin
     * @Date:2020/4/24 15:08
     */
    SysUser getSysUserByUserName(String username);
}
