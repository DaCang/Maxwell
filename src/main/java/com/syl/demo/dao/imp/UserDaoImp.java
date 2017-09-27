package com.syl.demo.dao.imp;

import com.syl.demo.dao.UserDao;
import com.syl.demo.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("userDaoImp")
public class UserDaoImp implements UserDao {


    static Logger logger = Logger.getLogger(UserDaoImp.class.getName());

    @Resource
    UserDao userDao;

    @Override
    public Boolean findUser () {
        return true;
    }

    @Override
    public List<User> getUserInfo (User user) {

        return userDao.getUserInfo(user);
    }

    @Override
    public int createUser (User user) {
        try {
            return userDao.createUser(user);
        }catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int deleteUser (User user) {

        try {
            return userDao.deleteUser(user);
        }catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<User> getUserInfoByPage(int start,int row_count) {

        return userDao.getUserInfoByPage(start,row_count );
    }

    public static void main (String[] args) {
        String version= System.getProperty("java.version");
        System.out.println(version);
    }

}
