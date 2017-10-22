package com.syl.demo.dao;

import com.syl.demo.pojo.Page;

import java.util.List;

public interface   BaseDao<T> {

    public  abstract List<T>  findList(T t);

    public  abstract List<T>  findAllList();

    public Page pageCount();


    public  abstract int  delete(T t);
}
