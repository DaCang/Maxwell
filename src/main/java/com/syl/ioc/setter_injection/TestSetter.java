package com.syl.ioc.setter_injection;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

/**
 * 测试setter 方法注入
 */
public class TestSetter {
    @Resource( name = "user01")
    User user;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext(
                "/spring.xml");

        User user = (User) context.getBean("user01");
        user.eating();
        user.getFood().eaten();


    }

    @Test
    public void testDemo(){
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext(
                "/spring.xml");
        User user = (User) context.getBean("user01");
        user.eating();
        user.getFood().eaten();

    }



}
