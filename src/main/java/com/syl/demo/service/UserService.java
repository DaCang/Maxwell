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
    public String getUserInfo(String user_id,String role_id){
        userDaoImp = new UserDaoImp();//测试的时候打开
        List userList;
        User user ;
        user =  new User();
        user.setUserId(user_id);
        if(!role_id.contains("system")){//如果不是system,只查询本人信息
            user.setRoleId(role_id);
        }
        userList = userDaoImp.getUserInfo(user);//根据user_id查询用户信息
        return ObjectToJson(userList);
    }

    public boolean createUser (User user) {
        userDaoImp = new UserDaoImp();//测试的时候打开
        int res =userDaoImp.createUser(user);
        if(res>0){
            System.out.println("插入成功！"+res+"行受影响！");
            return true;
        }
        return false;
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
