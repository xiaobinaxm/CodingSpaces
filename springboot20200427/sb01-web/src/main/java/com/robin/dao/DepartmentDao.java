package com.robin.dao;

import com.robin.pojo.Department;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 部门dao
 * @Author Robin
 * @Date 2020/4/28 9:11
 */
@Component
public class DepartmentDao {

    //模拟数据库中数据
    private static Map<Integer, Department> departments = null;
    static {
        departments = new HashMap<>();//模拟创建一个数据库表
        departments.put(101, new Department(101, "教学部"));
        departments.put(102, new Department(102, "市场部"));
        departments.put(103, new Department(103, "教研部"));
        departments.put(104, new Department(104, "运营部"));
        departments.put(105, new Department(105, "行政部"));
        departments.put(106, new Department(106, "公关部"));
        departments.put(107, new Department(107, "人事部"));
        departments.put(108, new Department(108, "后勤部"));
    }

    //获取所有部门信息
    public Collection<Department> getDepartments() {
        return departments.values();
    }



    //通过ID获取部门信息
    public Department getDepartmengById(Integer id) {
        return departments.get(id);
    }













}




































