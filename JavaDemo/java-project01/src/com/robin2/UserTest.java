package com.robin2;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @Description
 * @Author Robin
 * @Date 2019/10/1 21:27
 */
public class UserTest {

    @Test
    public void test(){


        //为了能够回来，不停的玩
        while (true){
            System.out.println("--------欢迎光临--------");
            System.out.println("1 登陆");
            System.out.println("2 注册");
            System.out.println("3 退出");


            System.out.println("请输入你的选择：");

            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();

            //把共性的提取出来
            UserDao ud = new UserDaoImpl();

            switch (s){
                case "1":
                    System.out.println("登陆界面");
                    System.out.println("请输入用户名：");
                    String username = sc.nextLine();
                    System.out.println("请输入密码：");
                    String password = sc.nextLine();
                    boolean login = ud.isLogin(username, password);
                    if (login){
                        System.out.println("登陆成功！");
                    } else {
                        System.out.println("用户名或密码错误，请重新登陆！");
                    }
                    break;
                case "2" :
                    System.out.println("注册界面");
                    System.out.println("请输入用户名：");
                    String newUsername = sc.nextLine();
                    System.out.println("请输入密码：");
                    String newPassword = sc.nextLine();

                    User user = new User();
                    user.setUsername(newUsername);
                    user.setPassword(newPassword);

                    ud.register(user);
                    System.out.println("注册成功！");
                    break;
                default:
                    System.out.println("谢谢使用，欢迎下次再来！");
                    System.exit(0);
                    break;
            }
        }

    }
}
