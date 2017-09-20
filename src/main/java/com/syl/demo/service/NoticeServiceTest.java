package com.syl.demo.service;

import com.syl.demo.dao.imp.NoticeDaoImp;
import com.syl.demo.util.SpringXmlContextUtil;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.Assert.*;

public class NoticeServiceTest {
    @Test
    public void getNoticeObject () throws Exception {
        NoticeService ns = new NoticeService();
        ns.getNoticeObject();
    }

    @Test
    public void work () throws Exception {

        NoticeService ns = new NoticeService();

        ns.work();

    }

}