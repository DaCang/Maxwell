package com.syl.demo.dao;

import java.util.List;

public interface   BaseDao<T> {
    public  abstract List<T>  findAllList();
}
