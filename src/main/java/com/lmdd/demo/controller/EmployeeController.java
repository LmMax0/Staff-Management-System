package com.lmdd.demo.controller;

import com.lmdd.demo.dao.DepartmentDao;
import com.lmdd.demo.dao.EmployeeDao;
import com.lmdd.demo.pojo.Department;
import com.lmdd.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toaddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee, HttpServletResponse response){
        //添加操作
        System.out.println(employee);
    //    response.setContentType("text/html;charset=utf-8");
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/upemp/{empid}")
    public String toUpdateEmp(@PathVariable("empid") int empid,Model model){
        System.out.println("====>>>>>>>"+empid);
        Employee employee = employeeDao.getEmployeeById(empid);
        model.addAttribute("emp",employee);

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){

        employeeDao.save(employee);
        return "redirect:/emps";
    }
    @RequestMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

    @RequestMapping("/user/loginout")
    public String loginOut(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }

}
