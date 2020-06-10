package com.robin.sbsecurity02.mapper;

import com.robin.sbsecurity02.bean.Role;
import com.robin.sbsecurity02.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/10 15:11
 */
@Mapper
public interface UserMapper {
    User loadUserByUsername(String username);

    List<Role> getUserRolesById(Integer id);
}
