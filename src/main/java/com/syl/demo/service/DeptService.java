package com.syl.demo.service;

import com.syl.demo.dao.imp.DeptDaoImp;
import com.syl.demo.pojo.Dept;


public class DeptService extends CommonService {

    DeptDaoImp deptDaoImp;

   public  String res(String dept_id){
       return ObjectToJson(getDeptInfo (dept_id));
   }

    public  <T> T getDeptInfo (String dept_id) {

        Dept dept = new Dept();
        dept.setDeptId(dept_id);

        return (T)deptDaoImp.getDeptInfo(dept);
    }

    public void setDeptDaoImp (DeptDaoImp deptDaoImp) {
        this.deptDaoImp = deptDaoImp;
    }

}
