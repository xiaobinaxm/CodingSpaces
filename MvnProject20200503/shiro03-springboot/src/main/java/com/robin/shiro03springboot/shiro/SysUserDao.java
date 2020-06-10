package com.robin.shiro03springboot.shiro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/24 14:49
 */
@Component
public interface SysUserDao extends JpaRepository<SysUser,Long> {
    /**
     * @Description：通过用户名查找用户
     * @Author:Robin
     * @Date:2020/4/24 15:06
     */
    SysUser getSysUserByUserName(String username);
}
