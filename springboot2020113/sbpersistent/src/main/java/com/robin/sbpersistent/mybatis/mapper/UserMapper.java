package com.robin.sbpersistent.mybatis.mapper;

import com.robin.sbpersistent.bean.User;
//import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/8 1:28
 */
//@Mapper   //这个方法不好，是因为需要在每一个mappper上面标注这个注解，直接在启动类上开启包扫描
//@Component    老版本开启注解后，可以解决Autowired注解bean时报错，但是新版本无法解决该问题，通过修改检验级别或者使用resource注解可以解决
//@Repository
public interface UserMapper {

    List<User> getAllUsers();
}
