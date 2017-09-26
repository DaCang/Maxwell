package com.syl.demo.dao.imp;

import com.syl.demo.dao.RoleDao;
import com.syl.demo.pojo.Role;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("roleDaoImp")
public class RoleDaoImp implements RoleDao {

    @Resource
    RoleDao roleDao;

    @Override
    public List<Role> getRoleInfo (Role role) {
        SqlSession session = null;
        List<Role> roleList;
        try {
            roleList = roleDao.getRoleInfo(role);
        } finally {
            session.close();
        }
        return roleList;
    }
}
