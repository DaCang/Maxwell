package com.syl.demo.dao.imp;

import com.syl.demo.dao.RoleDao;
import com.syl.demo.pojo.Role;
import com.syl.demo.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RoleDaoImp implements RoleDao {
    @Override
    public List<Role> getRoleInfo (Role role) {
        SqlSession session = null;
        List<Role> roleList;
        try {


            session = MybatisUtil.getSession();
            RoleDao roleDao = session.getMapper(RoleDao.class);
            roleList = roleDao.getRoleInfo(role);
        } finally {
            session.close();
        }
        return roleList;
    }
}
