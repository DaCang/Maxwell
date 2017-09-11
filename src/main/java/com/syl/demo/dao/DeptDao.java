package com.syl.demo.dao;

import com.syl.demo.pojo.Dept;

import java.util.List;

public interface DeptDao {



     List<Dept> getDeptInfo(String dept_id);

     boolean createDept(Dept dept);
}
