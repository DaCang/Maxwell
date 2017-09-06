package com.syl.demo.service;

import com.syl.demo.dao.imp.NoticeDaoImp;
import com.syl.demo.util.FileUtil;
import java.io.File;
import java.io.IOException;

public class NoticeService {

    NoticeDaoImp noticeDaoImp;
    private  final  String fileName="notice.json";

    public  void work(){
        // file(内存)----输入流---->【程序】----输出流---->file(内存)

        System.out.println("----");
        FileUtil.writeTOFile( noticeDaoImp.getNoticeStr(),getPath(),fileName);
    }

    public NoticeDaoImp getNoticeDaoImp () {
        return noticeDaoImp;
    }

    public void setNoticeDaoImp (NoticeDaoImp noticeDaoImp) {
        this.noticeDaoImp = noticeDaoImp;
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
}
