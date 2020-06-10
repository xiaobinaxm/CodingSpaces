package com.robin.dao;

import com.robin.entity.Student;

import java.util.List;

/**
 * @Description:
 * @author:Robin
 * @date:2017/10/3 0003 13:45:44
 */
public interface StudentMapper {

    //interface  接口都是public，所以这个public是多余的，可以删除
    public int insertStudent(Student student) throws Exception;

    Student selectOneById(int id) throws Exception;

    List<Student> selectAllStudent();

}
