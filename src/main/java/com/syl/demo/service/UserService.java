package com.syl.demo.service;

import com.syl.demo.dao.imp.NoticeDaoImp;
import com.syl.demo.dao.imp.UserDaoImp;
import com.syl.demo.pojo.User;
import com.syl.demo.util.SpringXmlContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService extends  CommonService {
    @Autowired
    UserDaoImp userDaoImp;



    public String getUserInfo(String user_id,String role_id){
        //userDaoImp = new UserDaoImp();//测试的时候打开
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
       // userDaoImp = new UserDaoImp();//测试的时候打开
        int res =userDaoImp.createUser(user);
        if(res>0){
            System.out.println("插入成功！"+res+"行受影响！");
            return true;
        }
        return false;
    }
    public boolean deleteUser (String user_id) {
        //userDaoImp = new UserDaoImp();//测试的时候打开
        User user = new User();
        user.setUserId(user_id);
        int res =userDaoImp.deleteUser(user);
        if(res>0){
            System.out.println("删除成功！"+res+"行受影响！");
            return true;
        }
        return false;
    }


    public  String getUserInfoByPage(int page){
       // userDaoImp = new UserDaoImp();//测试的时候打开
        List userList;
        int aPagSize=5;
        int start=0;
        int end=0;
        start=(page-1)*aPagSize;
        end=aPagSize;

        userList = userDaoImp.getUserInfoByPage(start,end);//根据user_id查询用户信息

        return ObjectToJson(userList);

    }

    @Override
    public String ObjectToJson (Object object) {
        return super.ObjectToJson(object);
    }
}
