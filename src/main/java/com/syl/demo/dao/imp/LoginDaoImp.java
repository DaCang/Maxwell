package com.syl.demo.dao.imp;

import com.syl.demo.dao.LoginDao;
import com.syl.demo.pojo.User;
import com.syl.demo.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;


public class LoginDaoImp implements LoginDao {

    @Override
    public User findUser (User user) {

        SqlSession session = null;
        User u;
        try {


            session = MybatisUtil.getSession();
            LoginDao loginDao = session.getMapper(LoginDao.class);
            u = loginDao.findUser(user);

        } finally {
            session.close();
        }
        return u;
    }
}
