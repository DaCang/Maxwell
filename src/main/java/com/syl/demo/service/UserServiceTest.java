package com.syl.demo.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    @Test
    public void getUserInfo () throws Exception {

        String userInfo;
        UserService userService = new UserService();
        userInfo = userService.getUserInfo("system");
        System.out.println(userInfo);
        userInfo = userService.getUserInfo("syl");
        System.out.println(userInfo);
    }

}