package com.syl.demo.dao.imp;

import com.syl.demo.dao.DeptDao;
import com.syl.demo.pojo.Dept;
import org.apache.log4j.Logger;

import java.util.List;


public class DeptDaoImp implements DeptDao {

    static Logger logger = Logger.getLogger(UserDaoImp.class.getName());


    @Override
    public List<Dept> getDeptInfo (String dept_id) {
        return null;
    }

    @Override
    public boolean createDept (Dept dept) {
        return false;
    }
}
