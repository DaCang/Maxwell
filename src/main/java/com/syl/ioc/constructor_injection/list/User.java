package com.syl.ioc.constructor_injection.list;

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

        for (String foodName :food.getFoodName()
             ) {
            System.out.println(userName+" 正在吃 "+foodName);
        }

    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
