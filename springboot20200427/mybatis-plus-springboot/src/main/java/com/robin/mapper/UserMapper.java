package com.robin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.robin.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description 对应的mapper上面继承基本的类BaseMapper即可
 * @Author Robin
 * @Date 2020/4/25 15:43
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    //至此所有基本CRUD基本完成，可以满足我们大部分的需求
    //对于不能满足我们需求的地方，在自己书写即可
    //毕竟，工具不是万能的

}
