package com.syl.demo.service;

import com.syl.demo.dao.imp.NoticeDaoImp;

public class NoticeService {

    NoticeDaoImp noticeDaoImp;

    public  void work(){
        noticeDaoImp.getNoticeObject();
        noticeDaoImp.getNoticeStr();
    }

    public NoticeDaoImp getNoticeDaoImp () {
        return noticeDaoImp;
    }

    public void setNoticeDaoImp (NoticeDaoImp noticeDaoImp) {
        this.noticeDaoImp = noticeDaoImp;
    }
}
