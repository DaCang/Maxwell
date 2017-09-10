package com.syl.demo.service;

import com.syl.demo.dao.NoticeDao;
import com.syl.demo.dao.imp.NoticeDaoImp;
import com.syl.demo.pojo.Notice;
import com.syl.demo.util.FileUtil;
import com.syl.demo.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class NoticeService  extends CommonService {

    NoticeDaoImp noticeDaoImp;
    private  final  String fileName="notice.json";

    public  void work(){
        getWork(noticeDaoImp);
    }

    public NoticeDaoImp getNoticeDaoImp () {
        return noticeDaoImp;
    }

    public void setNoticeDaoImp (NoticeDaoImp noticeDaoImp) {
        this.noticeDaoImp = noticeDaoImp;
    }



    public void getWork(NoticeDaoImp noticeDaoImp ){
        // file(内存)----输入流---->【程序】----输出流---->file(内存)
        String noticeStr = ObjectToJson(noticeDaoImp.getNoticeObject());
        //String noticeStr = ObjectToJson(getNoticeObject ());
        FileUtil.writeTOFile( noticeStr,getPath(),fileName);
    }

    @Override
    public String ObjectToJson(Object object){
        return super.ObjectToJson(object);
    }


    public static String getPath(){
        File directory = new File("");// 参数为空
        String courseFile = null;
        try {
            courseFile = directory.getCanonicalPath().replace("bin","webapps")+"\\spring-demo-02\\notice\\";
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        //return courseFile;
        return "D:\\ideaWORK\\spring-demo-02\\src\\main\\webapp\\notice"; //IDEA下打开
    }
    public List<Notice> getNoticeObject () {

        SqlSession session = null;
        List<Notice> notice;
        try {

            session = MybatisUtil.getSession();
            NoticeDao noticeDao = session.getMapper(NoticeDao.class);
            notice = noticeDao.getNoticeObject();
            System.out.println(notice.toString());
           /* Dept d = new Dept();
            d.setDeptId("20170909001");
            d.setDeptName("第一支部一分部");
            d.setDeptUp("20170909");
            deptDao.createDept(d);
            session.commit();*/

        } finally {
            session.close();
        }
        return notice;
    }
}
