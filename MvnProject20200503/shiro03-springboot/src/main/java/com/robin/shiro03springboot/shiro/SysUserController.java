package com.robin.shiro03springboot.shiro;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/24 16:36
 */
@RestController
public class SysUserController {
    @Resource
    SysUserService sysUserService;

    //通过username从数据库中获取用户信息
    @GetMapping("/userList")
    @RequiresPermissions("users:view")
    public SysUser getSysUserByUserName(@RequestParam String username) {
        return sysUserService.getSysUserByUserName(username);
    }

    //简单模拟从数据库中添加用户成功
    @PostMapping("/userAdd")
    @RequiresPermissions("users:add")
    public String addSysUser() {
        return "addSysUser success";
    }

    //简单模拟从数据库中删除用户成功
    @DeleteMapping("/sysUserDelete")
    @RequiresPermissions("users:delete")
    public String deleteSysUser() {
        return "deleteSysUser success";
    }

}
