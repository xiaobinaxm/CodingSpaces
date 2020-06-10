package com.robin.sbsecurity03dy.mapper;

import com.robin.sbsecurity03dy.bean.Role;
import com.robin.sbsecurity03dy.bean.User;

import java.util.List;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/10 19:22
 */
public interface UserMapper {

    User loadUserByUsername(String username);

    List<Role> getRolesById(Integer id);

}
