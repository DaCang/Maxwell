package com.syl.demo.dao;

import com.syl.demo.pojo.Notice;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("noticeDao")
public interface NoticeDao {




    List<Notice> getNoticeObject ();
}
