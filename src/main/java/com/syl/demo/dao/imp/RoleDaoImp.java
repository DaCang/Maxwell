package com.syl.demo.dao.imp;

import com.syl.demo.dao.RoleDao;
import com.syl.demo.pojo.Role;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("roleDaoImp")
public class RoleDaoImp implements RoleDao {

    @Resource
    RoleDao roleDao;

    @Override
    public List<Role> getRoleInfo (Role role) {
        return roleDao.getRoleInfo(role);
    }
}
