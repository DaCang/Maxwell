package com.syl.ioc.constructor_injection.list;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试构造方法注入<list>标签
 * */
public class TestConstructorList {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("classpath:/spring-constructor-list.xml");
        User user = (User) context.getBean("user");
        //user.setUserName(null);
        user.eating();
        user.food.eaten();


    }



}
