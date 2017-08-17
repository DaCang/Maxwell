package com.syl.ioc.constructor_injection.map;

import java.util.Map;

public class Food {

   Map<Integer,String> foodMap;

    public Food() {
    }

    public Food (Map foodMap) {
        this.foodMap = foodMap;
    }

    public void eaten( ){
        for (Object key : this.foodMap.keySet()) {
            System.out.println("编号为 "+key.toString()+" 的食物： "+this.foodMap.get(key)+" 正在被吃！");
        }
    }

    public Map getFoodMap () {
        return foodMap;
    }

    public void setFoodMap (Map foodMap) {
        this.foodMap = foodMap;
    }
}
