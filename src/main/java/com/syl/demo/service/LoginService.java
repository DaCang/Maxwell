package com.syl.demo.service;

import com.syl.demo.dao.imp.LoginDaoImp;
import com.syl.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService extends  CommonService {


    @Autowired
    LoginDaoImp loginDaoImp;

    public  User findUser(String user_id,String passWord){

        User user = new User();
        user.setUserId(user_id);
        user.setPassWord(passWord);
        User u;
        u = loginDaoImp.findUser(user);


        return u;
    }


}
