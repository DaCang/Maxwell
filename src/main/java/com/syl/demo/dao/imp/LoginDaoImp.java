package com.syl.demo.dao.imp;

import com.syl.demo.dao.LoginDao;
import com.syl.demo.pojo.User;
import com.syl.demo.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;


public class LoginDaoImp implements LoginDao {
    @Override
    public Integer findUser (User user) {

        SqlSession session = null;
        int count;
        try {


            session = MybatisUtil.getSession();
            LoginDao loginDao = session.getMapper(LoginDao.class);
            count = loginDao.findUser(user);

        } finally {
            session.close();
        }
        return count;
    }
}
