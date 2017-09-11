package com.syl.demo.util;

import com.syl.demo.dao.DeptDao;
import com.syl.demo.dao.NoticeDao;
import com.syl.demo.pojo.Dept;
import com.syl.demo.pojo.Notice;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;


public class MybatisUtilTest {

    @Test
    public void  testMybatis(){

        SqlSession session = null;
        try {

            session =MybatisUtil.getSession();
            DeptDao deptDao =  session.getMapper(DeptDao.class);
            Dept d = new Dept();
            d.setDeptId(null);
            List<Dept> dept =deptDao.getDeptInfo(d);
            System.out.println(dept.toString());
           /* Dept d = new Dept();
            d.setDeptId("20170909001");
            d.setDeptName("第一支部一分部");
            d.setDeptUp("20170909");
            deptDao.createDept(d);
            session.commit();*/


//            List<Notice> notice ;
//            session = MybatisUtil.getSession();
//            NoticeDao noticeDao =  session.getMapper(NoticeDao.class);
//            notice =noticeDao.getNoticeObject();
//            System.out.println(notice.toString());

        } finally {
            session.close();
        }
    }

}