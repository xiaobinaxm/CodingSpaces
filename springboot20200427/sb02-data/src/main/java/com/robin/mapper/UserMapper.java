package com.robin.mapper;

import com.robin.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/30 11:56
 */
//@Mapper   //这个地方也可以使用mapper，不过一般都统一采用在主类下配置基本包扫描
@Repository
public interface UserMapper {
    //这个2个事等价的
//    int age = 18;
//    public static final int age = 18;


//    当然如果为了方便测试，也是可以直接在此处采用注解的形式开发的,这样可以直接不用写烦人的xxxMapper.xml文件
//    @Select("select * from User")
    List<User> queryUserList();


    User getUserById(Integer id);

    int addUser(User user);

    int updateUser(User user);

//    @Delete("delete from user where id = #{id}")
    int deleteUserById(int id);

}
