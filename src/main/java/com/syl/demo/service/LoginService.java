package com.syl.demo.service;

import com.syl.demo.dao.LoginDao;
import com.syl.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService extends  CommonService {


    @Autowired
    LoginDao loginDao;

    public  User findUser(User user){

        return loginDao.findUser(user);
    }


}
