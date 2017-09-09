package com.syl.demo.util;

import com.syl.demo.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpringXmlContextUtilTest {
    @Test
    public void getBean () throws Exception {
        User u = SpringXmlContextUtil.getBean("user");
        u.setUserName("syl");
        System.out.println(u.toString());
    }

}