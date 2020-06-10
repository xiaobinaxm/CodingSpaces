package com.robin.shiro03springboot.shiro;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/**
 * @Description 用户信息
 * @Author Robin
 * @Date 2020/4/23 9:29
 */
@Entity
public class SysUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//主键
    @Column(unique = true)
    private String username;//登陆账户，唯一
    private String name;//名称（匿名或真实姓名），用于UI显示
    private String password;//密码
    private String salt;//加密密码的盐
    @JsonIgnoreProperties(value = {"users"})
    @ManyToMany(fetch = FetchType.EAGER)//立即从数据库中加载数据
    @JoinTable(name = "SysUserRole",joinColumns = @JoinColumn(name = "uid"),inverseJoinColumns = @JoinColumn(name = "roleId"))
    private List<SysRole> roles;//一个用户有多个角色

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }
}
