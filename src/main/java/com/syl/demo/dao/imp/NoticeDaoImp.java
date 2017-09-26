package com.syl.demo.dao.imp;

import com.syl.demo.dao.NoticeDao;
import com.syl.demo.pojo.Notice;
import com.syl.demo.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("deptDaoImp")
public class NoticeDaoImp implements NoticeDao {

    static Logger logger = Logger.getLogger(UserDaoImp.class.getName());

    @Override
    public List<Notice> getNoticeObject () {
        SqlSession session = null;
        List<Notice> noticeList;
        try {


            session = MybatisUtil.getSession();
            NoticeDao noticeDao = session.getMapper(NoticeDao.class);
            noticeList = noticeDao.getNoticeObject();

        } finally {
            session.close();
        }
        return noticeList;
    }

    public static void main (String[] args) {


            }



}
