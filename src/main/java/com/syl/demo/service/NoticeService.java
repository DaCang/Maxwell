package com.syl.demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.syl.demo.dao.imp.NoticeDaoImp;
import com.syl.demo.util.FileUtil;
import java.io.File;
import java.io.IOException;

public class NoticeService  extends  AbstractService{

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
}
