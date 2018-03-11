package com.syl.demo.service;

import com.syl.demo.dao.UserDao;
import com.syl.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author syl
 */
@Service
public class LoginService extends  CommonService {


    @Autowired
    UserDao userDao;

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
    public  User findUser(User user){

        return userDao.findUser(user);
    }


}
