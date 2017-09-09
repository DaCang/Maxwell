package com.syl.demo.util;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * java application test
 */
public class SpringXmlContextUtil {

    /**
     * @param bean_id
     * @param <T>
     * @return
     *
     */
    public  static  <T> T getBean(String bean_id){
        try {
            ClassPathXmlApplicationContext context = new
                                    ClassPathXmlApplicationContext("classpath:/*.xml");
            T t = (T)   context.getBean(bean_id);
            //user.setUserName(null);

            return   t;
        } catch (BeansException e) {
            System.out.println("spring 初始化上下文错误:"+e.getMessage());
            return null;
        }

    }


}
