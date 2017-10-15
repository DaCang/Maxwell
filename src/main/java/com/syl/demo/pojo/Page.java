package com.syl.demo.pojo;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Page<T>{

    int count;//总条数

    int pageCount;//总页数

    int pageNum;//当前页数

    List<T> list;//分页实体中包含的list

    public int getCount () {
        return count;
    }

    public void setCount (int count) {
        this.count = count;
    }

    public int getPageCount () {
        return (count-1)/5+1;
    }

    public void setPageCount (int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageNum () {
        return pageNum;
    }

    public void setPageNum (int pageNum) {
        this.pageNum = pageNum;
    }

    public List<T> getList () {
        return list;
    }

    public void setList (List<T> list) {
        this.list = list;
    }
}
