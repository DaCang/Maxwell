package com.syl.demo.service;

import com.syl.demo.dao.imp.LoginDaoImp;
import com.syl.demo.pojo.User;

public class LoginService extends  CommonService {

    LoginDaoImp loginDaoImp;
    public  User findUser(String user_id,String passWord){

        User user = new User();
        user.setUserId(user_id);
        user.setPassWord(passWord);
        User u;
        u = loginDaoImp.findUser(user);


        return u;
    }

    public LoginDaoImp getLoginDaoImp () {
        return loginDaoImp;
    }

    public void setLoginDaoImp (LoginDaoImp loginDaoImp) {
        this.loginDaoImp = loginDaoImp;
    }
}
