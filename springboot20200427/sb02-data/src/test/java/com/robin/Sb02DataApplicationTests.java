package com.robin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Sb02DataApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void test() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        Class<? extends DataSource> aClass = dataSource.getClass();
        System.out.println(aClass);
        //com.mysql.jdbc.JDBC4Connection@2a04ab05
        //class com.alibaba.druid.pool.DruidDataSource
    }


}
