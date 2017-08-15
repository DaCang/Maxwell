package com.syl.ioc.setter_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

//@Resource(name = "food")
//@Component(value = "food")
public class Food {

    int foodId;
    String foodName;

    public Food() {
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    //@Autowired
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void eaten(){

        System.out.println(foodName+" 被吃了");
    }
}
