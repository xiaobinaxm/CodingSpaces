package com.robin2;

/**
 * @Description
 * @Author Robin
 * @Date 2019/10/1 21:13
 */
public interface UserDao {
    boolean isLogin(String username, String password);

    void register(User user);
}
