package com.syl.demo.dao;


import com.syl.demo.pojo.User;

public interface UserDao {


    Boolean findUser(User user);

    User getUserInfo();


}
