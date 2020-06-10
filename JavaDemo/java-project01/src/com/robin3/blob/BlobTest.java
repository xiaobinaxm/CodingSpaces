package com.robin3.blob;

import com.robin3.bean.Customer;
import com.robin3.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.sql.*;

/**
 * @Description 测试使用PreparedStatement操作Blob类型数据
 * @Author Robin
 * @Date 2019/10/20 10:22
 */
public class BlobTest {

    //向数据表中插入Blob类型数据
    @Test
    public void test() throws Exception{
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into customers(name,email,birth,photo) values(?,?,?,?) ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, "Robin");
        ps.setObject(2,"robin@163.com");
        ps.setObject(3,"1992-02-18");
        FileInputStream is = new FileInputStream(new File("girl1.jpg"));
        ps.setBlob(4,is);

        ps.execute();

        JDBCUtils.closeResources(connection,ps);

    }



    //查询
    @Test
    public void testQueryPhoto(){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select id,name,email,birth,photo from customers where id = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,22);

            rs = ps.executeQuery();

            while (rs.next()){
//                int id = rs.getInt(1);
//                String name = rs.getString(2);
//                String email = rs.getString(3);
//                Date birth = rs.getDate(4);
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date birth = rs.getDate("birth");
                Customer customer = new Customer(id, name, email, birth);
                System.out.println(customer);

                //获取Blob类型的图片下载下来并保存到本地
                Blob photo = rs.getBlob("photo");
                is = photo.getBinaryStream();

                fos = new FileOutputStream("girlpp.jpg");
                byte[] bys = new byte[1024];
                int len;
                while ((len = is.read(bys)) != -1){
                    fos.write(bys,0,len);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            JDBCUtils.closeResources(connection,ps,rs);
        }

    }

    //查询数据表customers中Blob类型的字段
    @Test
    public void testQuery(){
        Connection conn = null;
        PreparedStatement ps = null;
        InputStream is = null;
        FileOutputStream fos = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select id,name,email,birth,photo from customers where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 21);
            rs = ps.executeQuery();
            if(rs.next()){
                //			方式一：
                //			int id = rs.getInt(1);
                //			String name = rs.getString(2);
                //			String email = rs.getString(3);
                //			Date birth = rs.getDate(4);
                //方式二：
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date birth = rs.getDate("birth");

                Customer cust = new Customer(id, name, email, birth);
                System.out.println(cust);

                //将Blob类型的字段下载下来，以文件的方式保存在本地
                Blob photo = rs.getBlob("photo");
                is = photo.getBinaryStream();
                fos = new FileOutputStream("zhangyuhao.jpg");
                byte[] buffer = new byte[1024];
                int len;
                while((len = is.read(buffer)) != -1){
                    fos.write(buffer, 0, len);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{

            try {
                if(is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            JDBCUtils.closeResources(conn, ps, rs);
        }


    }


}
