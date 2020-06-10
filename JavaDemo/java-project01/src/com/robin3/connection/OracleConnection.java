package com.robin3.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Description
 * @Author Robin
 * @Date 2019/10/16 21:42
 */
public class OracleConnection {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        InputStream resource = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.oracle.properties");
        Properties p = new Properties();
        p.load(resource);

        String driver = p.getProperty("driver");
        String url = p.getProperty("url");
        String username = p.getProperty("username");
        String password = p.getProperty("password");

        Class.forName(driver);

        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println(connection);


    }
}
