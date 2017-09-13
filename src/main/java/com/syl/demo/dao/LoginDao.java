package com.syl.demo.dao;

import com.syl.demo.pojo.User;

public interface LoginDao {

    Integer findUser(User user);
}
