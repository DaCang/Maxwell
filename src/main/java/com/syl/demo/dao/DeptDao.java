package com.syl.demo.dao;

import com.syl.demo.pojo.Dept;

import java.util.List;

public interface DeptDao {

     Dept getDeptInfo(String dept_id);


     List<Dept> getAllDeptInfo();

     boolean createDept(Dept dept);
}
