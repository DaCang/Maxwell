package com.syl.demo.dao.imp;

import com.syl.demo.dao.DeptDao;
import com.syl.demo.pojo.Dept;
import com.syl.demo.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.List;


public class DeptDaoImp implements DeptDao {

    static Logger logger = Logger.getLogger(UserDaoImp.class.getName());


    @Override
    public List<Dept> getDeptInfo (Dept dept) {
        SqlSession session = null;
        List<Dept> deptList;
        try {


            session = MybatisUtil.getSession();
            DeptDao deptDao = session.getMapper(DeptDao.class);
            deptList = deptDao.getDeptInfo(dept);
        } finally {
            session.close();
        }
        return deptList;
    }

    @Override
    public boolean createDept (Dept dept) {
        return true;
    }
}
