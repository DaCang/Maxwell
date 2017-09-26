package com.syl.demo.dao.imp;

import com.syl.demo.dao.DeptDao;
import com.syl.demo.pojo.Dept;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("deptDaoImp")
public class DeptDaoImp implements DeptDao {

    static Logger logger = Logger.getLogger(UserDaoImp.class.getName());

    @Resource
    DeptDao deptDao;

    @Override
    public List<Dept> getDeptInfo (Dept dept) {
        return deptDao.getDeptInfo(dept);
    }

    @Override
    public boolean createDept (Dept dept) {
        return true;
    }
}
