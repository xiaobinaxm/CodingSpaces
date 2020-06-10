package com.robin.controller;

import com.robin.dao.DepartmentDao;
import com.robin.dao.EmployeeDao;
import com.robin.pojo.Department;
import com.robin.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/29 18:52
 */
@Controller
public class EmployeeController {


    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "list";
    }


    @GetMapping("/addemp")
    public String addEmp(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "add";
    }

    @PostMapping("/addemplist")
    public String addEmp(Employee employee) {
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }



    @GetMapping("/preupdate/{id}")
    public String preupdate(@PathVariable("id")Integer id, Model model) {
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("employee", employee);

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);

        return "update";
    }



    @PostMapping("/updatelist")
    public String update(Employee employee) {
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }



    @GetMapping("/predelete/{id}")
    public String predelete(@PathVariable("id")Integer id) {
        employeeDao.deleteEmployee(id);
        return "redirect:/emps";
    }







}
