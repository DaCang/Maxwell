package com.syl.demo.pojo;

import org.springframework.stereotype.Component;

@Component
public class Page {

    String pageCount;//总条数

    String pageNum;//页数

    public String getPageCount () {
        return pageCount;
    }

    public void setPageCount (String pageCount) {
        this.pageCount = pageCount;
    }

    public String getPageNum () {

        return String.valueOf(Integer.valueOf(pageCount)/5+1);
    }

    public void setPageNum (String pageNum) {
        this.pageNum = pageNum;
    }
}
