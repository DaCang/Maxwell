package com.syl.demo.dao;

import com.syl.demo.pojo.Dept;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("deptDao")
public interface DeptDao extends  BaseDao {



     List<Dept> getDeptInfo(Dept dept);

     boolean createDept(Dept dept);
}
