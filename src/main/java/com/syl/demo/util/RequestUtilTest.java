package com.syl.demo.util;

import com.syl.demo.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class RequestUtilTest {
    @Test
    public void stringChange () throws Exception {
        RequestUtil.stringInsert_("password");
    }

    @Test
    public void getObjectByRequest () throws Exception {

        System.out.println(User.class.toString());
        RequestUtil r = new RequestUtil();
        r.getObjectByRequest(null, User.class);
    }

}