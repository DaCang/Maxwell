package com.syl.demo.util;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MybatisUtil {
    public static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    //public static SqlSession session ;
    static {
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MybatisUtil () {

    }

    public static SqlSession getSession () {

        return sqlSessionFactory.openSession();
    }


}

