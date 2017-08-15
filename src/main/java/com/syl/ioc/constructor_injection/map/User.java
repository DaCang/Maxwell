package com.syl.ioc.constructor_injection.map;

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

        for (Object key : food.getFoodMap().keySet()) {
            System.out.println(this.userName+" 正在吃 "+food.getFoodMap().get(key)+" ！");
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
