package com.syl.demo.service;

import com.syl.demo.dao.DeptDao;
import com.syl.demo.pojo.Dept;
import com.syl.demo.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;


public class DeptService extends CommonService {
    @Override
    public String ObjectToJson(Object object){
        return super.ObjectToJson(object);
    }

    public Dept getDeptInfo (String dept_id) {

        SqlSession session = null;
        Dept dept;
        try {

            session = MybatisUtil.getSession();
            DeptDao deptDao = session.getMapper(DeptDao.class);
            dept = deptDao.getDeptInfo(dept_id);
            System.out.println(dept.toString());
           /* Dept d = new Dept();
            d.setDeptId("20170909001");
            d.setDeptName("第一支部一分部");
            d.setDeptUp("20170909");
            deptDao.createDept(d);
            session.commit();*/

        } finally {
            session.close();
        }
        return dept;
    }
}
