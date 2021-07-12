package com.lmdd.demo.dao;

import com.lmdd.demo.pojo.Department;

import java.util.HashMap;
import java.util.Map;

public class DepartmentDao {
    private static Map<Integer, Department> departments = null;
    static {
        departments = new HashMap<Integer, Department>();

    }
}
