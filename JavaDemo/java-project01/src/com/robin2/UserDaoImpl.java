package com.robin2;

import java.util.ArrayList;

/**
 * @Description
 * @Author Robin
 * @Date 2019/10/1 21:15
 */
public class UserDaoImpl implements UserDao {
    //为了是多个方法使用同一个集合，我们把集合定义为成员变量
    //为了不让他人看见，只供本类使用，我们定义为private
    //为了让多个对象共享同一个成员变量，我们定义为static
//    private static HashMap<String, String> hs = new HashMap<String, String>();
    private static ArrayList<User> arr = new ArrayList<User>();

    //登陆成功与否标识
    boolean flag = false;

    //登陆验证
    @Override
    public boolean isLogin(String username, String password) {
        //遍历成员变量，获取注册的用户信息
        for (User u : arr){
            if (u.getUsername().equals(username) && u.getPassword().equals(password))
                flag = true;
                break;
        }
        return flag;
    }

    //注册
    @Override
    public void register(User user) {
        //把注册进来的用户放到共享成员变量中
        arr.add(user);
    }
}
