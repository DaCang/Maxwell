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

        //SqlSession session = null;
        User u;
        //try {


            /*session = MybatisUtil.getSession();
            LoginDao loginDao = session.getMapper(LoginDao.class);*/
            u = loginDao.findUser(user);

        //} finally {
          //  session.close();
       // }
        return u;
    }
}
