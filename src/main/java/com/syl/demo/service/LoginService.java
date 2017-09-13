package com.syl.demo.service;

import com.syl.demo.dao.imp.LoginDaoImp;
import com.syl.demo.pojo.User;

public class LoginService extends  CommonService {

    LoginDaoImp loginDaoImp;
    public  Boolean findUser(User user){

        int count;
        count = loginDaoImp.findUser(user);
        if (count != 1) {
            return false;
        }

        return true;
    }

    public LoginDaoImp getLoginDaoImp () {
        return loginDaoImp;
    }

    public void setLoginDaoImp (LoginDaoImp loginDaoImp) {
        this.loginDaoImp = loginDaoImp;
    }
}
