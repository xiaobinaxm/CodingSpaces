package com.robin.mapper;

import com.robin.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author Robin
 * @Date 2020/5/1 21:48
 */
@Repository
@Mapper
public interface UserMapper {

    User getUserByName(String name);

}
