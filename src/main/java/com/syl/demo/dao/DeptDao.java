package com.syl.demo.dao;

import com.syl.demo.pojo.Dept;

import java.util.List;

public interface DeptDao {



     List<Dept> getDeptInfo(Dept dept);

     boolean createDept(Dept dept);
}
