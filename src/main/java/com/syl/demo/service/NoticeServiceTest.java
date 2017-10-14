package com.syl.demo.service;

import org.junit.Test;

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