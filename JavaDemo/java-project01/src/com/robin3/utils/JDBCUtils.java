package com.robin3.utils;

import com.robin3.connection.MysqlConnectionTest;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Description JDBCUtils
 * @Author Robin
 * @Date 2019/10/16 23:25
 */
public class JDBCUtils {

    /**
     * @Description：获取连接
     * @Author:Robin
     * @Date:2019/10/16 23:34
     */
    public static Connection getConnection() throws Exception {
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
        return connection;
    }

    //关闭资源
    public static void closeResources(Connection connection, PreparedStatement ps){
        try {
            if (ps != null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //关闭资源
    public static void closeResources(Connection connection, PreparedStatement ps, ResultSet rs){
        try {
            if (rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (ps != null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
