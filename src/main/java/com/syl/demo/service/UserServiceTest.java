package com.syl.demo.service;

import com.syl.demo.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    @Test
    public void getUserInfoByPage () throws Exception {
        UserService userService = new UserService();
        System.out.println(userService.getUserInfoByPage(4));
    }

    @Test
    public void deleteUser () throws Exception {
        UserService userService = new UserService();
        System.out.println(userService.deleteUser("sfs"));
    }

    @Test
    public void createUser () throws Exception {
        User user = new User();
        user.setUserId("test");
        user.setUserName("测试");
        user.setPassWord("test");
        user.setRoleId("001");
        user.setDeptId("20170919001");
        user.setStatus("0");

        UserService userService = new UserService();
        System.out.println(userService.createUser(user));
    }

    @Test
    public void getUserInfo () throws Exception {

        String userInfo;
        UserService userService = new UserService();
        userInfo = userService.getUserInfo("admin","system");
        //System.out.println(userInfo);
        userInfo = userService.getUserInfo("syl","001");
        System.out.println(userInfo);
    }

}