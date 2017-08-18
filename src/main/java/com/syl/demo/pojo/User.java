package com.syl.demo.pojo;

import com.syl.ioc.setter_injection.Food;

//@Component(value = "user")
public class User {


    int userId;


    String userName;

    String passWord;

    Role role;


    public User () {
    }



    public int getUserId () {
        return userId;
    }

    public void setUserId (int userId) {
        this.userId = userId;
    }


    public String getUserName () {
        return userName;
    }


    public void setUserName (String userName) {
        this.userName = userName;
    }

    public String getPassWord () {
        return passWord;
    }

    public void setPassWord (String passWord) {
        this.passWord = passWord;
    }

    public Role getRole () {
        return role;
    }

    public void setRole (Role role) {
        this.role = role;
    }


}
