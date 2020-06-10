package com.robin.shiro03springboot.shiro;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/24 15:09
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    SysUserDao sysUserDao;
    @Override
    public SysUser getSysUserByUserName(String username) {
        return sysUserDao.getSysUserByUserName(username);
    }
}
