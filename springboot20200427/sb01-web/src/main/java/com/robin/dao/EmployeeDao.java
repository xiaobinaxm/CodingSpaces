package com.robin.dao;

import com.robin.pojo.Department;
import com.robin.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 员工Dao
 * @Author Robin
 * @Date 2020/4/28 9:23
 */
@Component
public class EmployeeDao {

    //模拟数据库中数据资源
    private static Map<Integer, Employee> employees = null;

    @Autowired
    DepartmentDao departmentDao;

    static {
        employees = new HashMap<>();
        employees.put(101,new Employee(101,"Robin1","robin1@163.com",1, new Department(101, "教学部")));
        employees.put(102,new Employee(102,"Robin2","robin2@163.com",1, new Department(102, "市场部")));
        employees.put(103,new Employee(103,"Robin3","robin3@163.com",1, new Department(103, "教研部")));
        employees.put(104,new Employee(104,"Robin4","robin4@163.com",1, new Department(104, "运营部")));
        employees.put(105,new Employee(105,"Robin5","robin5@163.com",0, new Department(105, "行政部")));
        employees.put(106,new Employee(106,"Robin6","robin6@163.com",0, new Department(106, "公关部")));
        employees.put(107,new Employee(107,"Robin7","robin7@163.com",0, new Department(107, "人事部")));
        employees.put(108,new Employee(108,"Robin8","robin8@163.com",1, new Department(108, "后勤部")));
    }


    //主键自增
    private static Integer initId = 109;

    //新增一个员工
    public void save(Employee employee) {
        if (null == employee.getId()) {
            employee.setId(initId++);
        }
        //这个类似于子查询，先通过员工ID查询部门ID，然后通过部门ID查询所有部门信息，最后将部门信息放到员工对象
        employee.setDepartment(departmentDao.getDepartmengById(employee.getDepartment().getId()));
        //将员工对象(信息)放到员工表中
        employees.put(employee.getId(), employee);
    }

    //查询全部员工
    public Collection<Employee> getAll() {
        return employees.values();
    }

    //通过ID查询员工信息
    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    //删除一个员工
    public void deleteEmployee(Integer id) {
        employees.remove(id);
    }




}
