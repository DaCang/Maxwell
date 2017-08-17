package com.syl.ioc.setter_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

//@Component(value = "user")
public class User {


    int userId;


    String userName;

   // @Autowired(required = true)
    Food food;

    public User() {
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

    public void eating(){
        System.out.println(userName+" 正在吃 "+food.getFoodName());
    }

    public Food getFood () {
        return food;
    }

    public void setFood (Food food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
