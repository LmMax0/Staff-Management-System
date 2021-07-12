package com.lmdd.demo.dao;

import com.lmdd.demo.pojo.Department;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
//部门dao
public class DepartmentDao {
    //用来模拟数据库中的数据
    private static Map<Integer, Department> departments = null;
    static {
        departments = new HashMap<Integer, Department>(); //创建一个部门表
        departments.put(101,new Department(101,"教学部"));
        departments.put(102,new Department(102,"市场部"));
        departments.put(103,new Department(103,"运营部"));
        departments.put(104,new Department(104,"教研部"));
        departments.put(105,new Department(105,"后勤部"));
        departments.put(106,new Department(106,"学生部"));
    }
    //获得所有部门的信息
    public Collection<Department> getDepartments(){
        return departments.values(); //返回一个所有value组成的集合
    }

    //通过id获取部门信息
    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }
}
