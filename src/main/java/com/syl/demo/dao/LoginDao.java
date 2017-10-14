package com.syl.demo.dao;

import com.syl.demo.pojo.User;
import org.springframework.stereotype.Repository;

@Repository("loginDao")
public interface LoginDao {

    User findUser(User user);
}
