package com.syl.demo.dao;

import com.syl.demo.pojo.Page;

import java.util.List;

public interface   BaseDao<T> {

    List<T>  findList(T t);

    List<T>  findAllList();

    Page pageCount();


    int  delete(T t);

    int insert(T t);
}
