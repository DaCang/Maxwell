package com.syl.demo.dao;

import com.syl.demo.pojo.Dept;

import java.util.List;

public interface DeptDao extends  BaseDao {



     List<Dept> getDeptInfo(Dept dept);

     boolean createDept(Dept dept);
}
