package com.syl.ioc.constructor_injection.list;

import java.util.List;

public class Food {

    int[] foodId;
    List<String> foodName;

    public Food() {
    }

    public Food (int[] foodId, List<String> foodName) {
        this.foodId = foodId;
        this.foodName = foodName;
    }

    public List<String> getFoodName () {
        return foodName;
    }

    public void setFoodName (List<String> foodName) {
        this.foodName = foodName;
    }

    public void eaten( ){
        for (String foodName :this.getFoodName()
                ) {
            System.out.println(foodName + " 被吃了");
        }
    }
}
