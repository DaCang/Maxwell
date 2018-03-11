package com.syl.demo.dao;

import com.syl.demo.pojo.User;
import org.springframework.stereotype.Repository;

/**
 *
 * @author syl
 */
@Repository("loginDao")
public interface LoginDao {

    /**
     * 根据userId和passWord判断用户是否存在
     * @Title:findUser
     * @Description: （根据userId和passWord判断用户是否存在）
     * @param user
     * @return
     * @author 宋永利
     * @date 2018/3/10
     * @throws
     */
    User findUser(User user);
}
