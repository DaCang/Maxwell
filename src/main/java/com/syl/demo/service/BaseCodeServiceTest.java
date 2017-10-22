package com.syl.demo.service;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = {"classpath:config/bean-spring-mybatis.xml"})
public class BaseCodeServiceTest {
    @Test
    public void work () throws Exception {
        BaseCodeService baseCodeService = new BaseCodeService();
       // baseCodeService.work();

        baseCodeService.writeRoleBaseCode();

        //SpringXmlContextUtil.getBean("roleDaoImp");

    }

}