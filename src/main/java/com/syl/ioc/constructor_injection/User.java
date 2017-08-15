package com.syl.ioc.constructor_injection;

public class User {

    int userId;
    String userName;
    Food food;

    public User() {
    }

    public User (int userId, String userName, Food food) {
        this.userId = userId;
        this.userName = userName;
        this.food = food;
    }



    public void eating(){
        System.out.println(userName+" 正在吃 "+food.getFoodName());
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
