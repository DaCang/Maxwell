package com.syl.demo.service;

import com.syl.demo.dao.imp.NoticeDaoImp;

import java.io.File;
import java.io.IOException;

public class NoticeService {

    NoticeDaoImp noticeDaoImp;

    public  void work(){
        // file(内存)----输入流---->【程序】----输出流---->file(内存)

        System.out.println("----");
        FileUtil.writeTOFile( noticeDaoImp.getNoticeStr(),FileUtil.getPath());
    }

    public NoticeDaoImp getNoticeDaoImp () {
        return noticeDaoImp;
    }

    public void setNoticeDaoImp (NoticeDaoImp noticeDaoImp) {
        this.noticeDaoImp = noticeDaoImp;
    }
}
