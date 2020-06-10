package com.robin3.preparedstatement;

import com.robin3.bean.Order;
import com.robin3.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Description
 * @Author Robin
 * @Date 2019/10/16 22:36
 */
public class PreparedStatementTest {


    public static <T> List<T> queryList(Class<T> calzz, String sql, Object...args){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = JDBCUtils.getConnection();
            ps = connection.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }

            rs = ps.executeQuery();

            //获取元数据
            ResultSetMetaData rsmt = rs.getMetaData();
            //获取列数
            int columnCount = rsmt.getColumnCount();

            ArrayList<T> list = new ArrayList<>();
            while (rs.next()){
                T t = calzz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    //获取列值
                    Object columnValue = rs.getObject(i + 1);
                    //获取列名
                    String columnLabel = rsmt.getColumnLabel(i+1);

                    Field field = calzz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,columnValue);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(connection,ps,rs);
        }
        return null;
    }




    //查询所有，所有指的是，一个对象的一行数据
    public static <T> T queryAll(Class<T> calzz,String sql,Object...args){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = JDBCUtils.getConnection();
            ps = connection.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }

            rs = ps.executeQuery();

            //获取元数据
            ResultSetMetaData rsmt = rs.getMetaData();
            //获取列数
            int columnCount = rsmt.getColumnCount();
            while (rs.next()){
                T t = calzz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    //获取列值
                    Object columnValue = rs.getObject(i + 1);
                    //获取列名
                    String columnLabel = rsmt.getColumnLabel(i+1);

                    Field field = calzz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,columnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(connection,ps,rs);
        }
        return null;
    }




    //通用查询
    public static Order query(String sql,Object...args) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = JDBCUtils.getConnection();
            ps = connection.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }

            rs = ps.executeQuery();

            //获取元数据
            ResultSetMetaData rsmt = rs.getMetaData();
            //获取列数
            int columnCount = rsmt.getColumnCount();
            if (rs.next()){
                Order order = new Order();
                for (int i = 0; i < columnCount; i++) {
                    //获取列值
                    Object columnValue = rs.getObject(i + 1);
                    //获取列名
                    String columnLabel = rsmt.getColumnLabel(i+1);

                    Field field = Order.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(order,columnValue);
                }
                return order;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(connection,ps,rs);
        }
        return null;
    }




    //通用增删改
    public void update(String sql,Object ...args) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1.获取连接
            connection = JDBCUtils.getConnection();
            //2.预编译sql,返回PreparedStatement
            ps = connection.prepareStatement(sql);
            //3.填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            //4.执行sql
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
            JDBCUtils.closeResources(connection,ps);
        }

    }



    //修改一条记录
    @Test
    public void testUpdate(){
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1.获取数据连接
            connection = JDBCUtils.getConnection();

            //2.预编译sql语句，返回PreparedStatement
            String sql = "update customers set name = ? where id = ?";
            ps = connection.prepareStatement(sql);
            //3.填充占位符
            ps.setString(1,"莫扎特");
            ps.setInt(2,18);
            //4.执行sql
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
            JDBCUtils.closeResources(connection,ps);
        }
    }


    //新增一条记录
    @Test
    public void testInsert() {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1.读取配置文件中的4个基本信息
            InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.mysql.properties");
            Properties p = new Properties();
            p.load(stream);

            String driverClass = p.getProperty("driverClass");
            String url = p.getProperty("url");
            String user = p.getProperty("user");
            String password = p.getProperty("password");

            //2.加载驱动
            Class.forName(driverClass);

            //3.获取连接
            connection = DriverManager.getConnection(url, user, password);

            //4.预编译sql处理，返回PreparedStatement的示例
            String sql = "insert into customers(name,email,birth) values(?,?,?)";//?占位符
            ps = connection.prepareStatement(sql);

            //5.填充占位符
            ps.setString(1,"nezha");
            ps.setString(2,"nezha@163.com");
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            Date date = sdf.parse("1000-01-01");
            ps.setDate(3, Date.valueOf("1000-01-01"));

            //6.执行sql
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //7.资源关闭
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
}
