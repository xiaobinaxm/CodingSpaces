package com.robin;

import com.robin.dao.StudentMapper;
import com.robin.entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

import static java.lang.System.in;

/**
 * @Description:
 * @author:Robin
 * @date:2017/10/3 0003 14:14:27
 */
public class Main {
    public static void main(String[] args) throws Exception {

        InputStream in = Main.class.getResourceAsStream("MyBaties01/resource/mybaties-cfg.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        SqlSession sqlSession = factory.openSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        Student student = new Student();

        student.setId(10);
        student.setName("韩语");
        student.setAge(24);
        student.setSex("女");
        student.settId(1);

        mapper.insertStudent(student);

        sqlSession.commit();
    }
}
