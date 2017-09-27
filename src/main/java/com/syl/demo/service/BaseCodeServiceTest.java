package com.syl.demo.service;

import com.syl.demo.util.SpringXmlContextUtil;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.*;

@ContextConfiguration(locations = {"classpath:bean-spring-mybatis.xml"})
public class BaseCodeServiceTest {
    @Test
    public void work () throws Exception {
        BaseCodeService baseCodeService = new BaseCodeService();
       // baseCodeService.work();

        baseCodeService.writeRoleBaseCode();

        //SpringXmlContextUtil.getBean("roleDaoImp");

    }

}