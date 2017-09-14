package com.syl.demo.service;

import com.syl.demo.dao.imp.NoticeDaoImp;
import com.syl.demo.dao.imp.UserDaoImp;
import com.syl.demo.pojo.User;
import com.syl.demo.util.SpringXmlContextUtil;

import java.util.ArrayList;
import java.util.List;

public class UserService extends  CommonService {
    UserDaoImp userDaoImp;


    public  Boolean findUser(User user){
        userDaoImp.findUser(user);
        return false;
    }
    public String getUserInfo(String user_id){
        //UserDaoImp userDaoImp = SpringXmlContextUtil.getBean("userDaoImp");
        List userList;
        User user ;
        user =  new User();
        user.setUserId(user_id);
        userList = userDaoImp.getUserInfo(user);//根据user_id查询用户信息

        //如果用户的权限是system查询所有用户信息
        if(((User)userList.get(0)).getRoleId().contains("system")){
            user =  new User();
            userList = userDaoImp.getUserInfo(user);//查询所有用户信息
        }
        return ObjectToJson(userList);
    }

    public UserDaoImp getUserDaoImp () {
        return userDaoImp;
    }

    public void setUserDaoImp (UserDaoImp userDaoImp) {
        this.userDaoImp = userDaoImp;
    }

    @Override
    public String ObjectToJson (Object object) {
        return super.ObjectToJson(object);
    }
}
