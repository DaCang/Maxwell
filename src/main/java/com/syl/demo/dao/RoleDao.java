package com.syl.demo.dao;

import com.syl.demo.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * role 表操作接口
 */
@Repository("roleDao")
public interface RoleDao extends  BaseDao {

    List<Role> getRoleInfo(Role role);
}
