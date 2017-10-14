package com.syl.demo.service;

import com.syl.demo.dao.DeptDao;
import com.syl.demo.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptService extends CommonService {

    @Autowired
    DeptDao deptDao;


    @Override
    public String ObjectToJson (Object object) {
        return super.ObjectToJson(object);
    }

    public  String getDeptInfo (String dept_id) {

        Dept dept = new Dept();
        dept.setDeptId(dept_id);

        return ObjectToJson(deptDao.getDeptInfo(dept));
    }




    public  String getDeptInfoByRole (String dept_id,String role_id) {
        Dept dept = new Dept();
       if(!role_id.contains("system")){
           dept.setDeptId(dept_id);
       }
        return ObjectToJson(deptDao.getDeptInfo(dept));





    }
}
