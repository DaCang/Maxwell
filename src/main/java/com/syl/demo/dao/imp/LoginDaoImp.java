package com.syl.demo.dao.imp;

import com.syl.demo.dao.LoginDao;
import com.syl.demo.pojo.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("loginDaoImp")
public class LoginDaoImp implements LoginDao {

    @Resource
    LoginDao loginDao;

    @Override
    public User findUser (User user) {
        return loginDao.findUser(user);
    }
}
