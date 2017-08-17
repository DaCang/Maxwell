package com.syl.ioc.constructor_injection.map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试构造方法注入<map>标签
 * */
public class TestConstructorMap {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext(
                        "file:D:\\ideaWORK\\SpringLearn\\src\\main\\webapp\\WEB-INF\\spring-constructor-map.xml");
        User user = (User) context.getBean("user");
        //user.setUserName(null);
        user.eating();
        user.food.eaten();


    }



}
