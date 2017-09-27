package com.syl.demo.dao.imp;

import com.syl.demo.dao.NoticeDao;
import com.syl.demo.pojo.Notice;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("noticeDaoImp")
public class NoticeDaoImp implements NoticeDao {

    static Logger logger = Logger.getLogger(UserDaoImp.class.getName());

    @Resource
    NoticeDao noticeDao;

    @Override
    public List<Notice> getNoticeObject () {
        return noticeDao.getNoticeObject();
    }



}
