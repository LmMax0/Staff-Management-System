package com.lmdd.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
// 员工
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender; // 0 女 1 男
    private Department department;
    private Date birth;
}
