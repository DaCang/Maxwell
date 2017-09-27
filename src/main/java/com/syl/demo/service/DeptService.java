package com.syl.demo.service;

import com.syl.demo.dao.imp.DeptDaoImp;
import com.syl.demo.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptService extends CommonService {

    @Autowired
    DeptDaoImp deptDaoImp;


    @Override
    public String ObjectToJson (Object object) {
        return super.ObjectToJson(object);
    }

    public  String getDeptInfo (String dept_id) {

        Dept dept = new Dept();
        dept.setDeptId(dept_id);

        return ObjectToJson(deptDaoImp.getDeptInfo(dept));
    }

    public void setDeptDaoImp (DeptDaoImp deptDaoImp) {
        this.deptDaoImp = deptDaoImp;
    }



    public  String getDeptInfoByRole (String dept_id,String role_id) {
        Dept dept = new Dept();
       if(!role_id.contains("system")){
           dept.setDeptId(dept_id);
       }
        return ObjectToJson(deptDaoImp.getDeptInfo(dept));





    }
}
