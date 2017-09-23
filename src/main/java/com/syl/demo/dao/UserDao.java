package com.syl.demo.dao;


import com.syl.demo.pojo.User;

import java.util.List;

public interface UserDao {


    Boolean findUser();

    //User getUserInfo();

    List<User> getUserInfo(User user);

    int createUser(User user);

    int deleteUser(User user);


}
