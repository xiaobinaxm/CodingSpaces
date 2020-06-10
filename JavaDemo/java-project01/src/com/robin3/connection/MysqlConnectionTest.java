package com.robin3.connection;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Description JDBC连接
 * @Author Robin
 * @Date 2019/10/15 23:24
 */
public class MysqlConnectionTest {


    //以下的几个方式都是迭代式的，属于递进式的，不属于有几种方法

    //方式一：
    @Test
    public void test() throws SQLException {

        Driver driver = new com.mysql.jdbc.Driver();
        String url = "jdbc:mysql://localhost:3306/test";//test是我们本次使用的数据库

        //将用户名和密码封装到properties
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","root");

        Connection connect = driver.connect(url, properties);
        System.out.println(connect);

    }



    //方式二：对方式一进行迭代:在如下的程序中不会出现第三方的API，是使得程序具备更好的可移植性
    @Test
    public void test2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        //1.获取Driver实现类对象：使用反射
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        //2.提供要连接的数据库
        String url = "jdbc:mysql://localhost:3306/test";

        //3.提供连接所需要的用户名和密码
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","root");

        //4.获取连接
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }


    //使用DriverManager替代Driver
    @Test
    public void test3() throws Exception {
        //获取Driver的实现类对象
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        //获取另外三个连接的基本信息
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "root";

        //注册驱动
        DriverManager.registerDriver(driver);

        //获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);

    }


    //方式4：可以只是加载驱动，不用显示的去注册驱动，自动加载过了
    @Test
    public void test4() throws Exception {
        //获取另外三个连接的基本信息
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "root";

        //加载Driver
        Class.forName("com.mysql.jdbc.Driver");

        //获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }


    //方法五:将数据库连接的4个基本信息，声明到配置文件中，通过读取配置文件的方式来连接数据库
    @Test
    public void test5() throws Exception {
        //读取配置信息
        //自定义类使用的加载器一般都是系统类加载器
        InputStream resource = MysqlConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.mysql.properties");
        Properties p = new Properties();
        p.load(resource);

        String user = p.getProperty("user");
        String password = p.getProperty("password");
        String url = p.getProperty("url");
        String driverClass = p.getProperty("driverClass");

        //加载驱动
        Class.forName(driverClass);
        //获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);


    }

}
