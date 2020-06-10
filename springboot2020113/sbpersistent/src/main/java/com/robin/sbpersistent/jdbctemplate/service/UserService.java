package com.robin.sbpersistent.jdbctemplate.service;

import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/7 23:56
 */
/*
@Service
public class UserService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Integer addUser(User user) {
        return jdbcTemplate.update("insert into user (username,address) values (?,?)", user.getUsername(), user.getAddress());
    }


    //本方法使用与属性名与字段名不一致的时候，一致的时候，均可以时使用
    public List<User> getAllUsers(){
        return jdbcTemplate.query("select * from user", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String address = resultSet.getString("address");

                user.setId(id);
                user.setUsername(username);
                user.setAddress(address);

                return user;
            }
        });
    }

    //本方法使用与属性名与字段名一致的时候使用
    public List<User> getAllUsers2(){
        return jdbcTemplate.query("select * from user",new BeanPropertyRowMapper<>(User.class));
    }


}
*/
