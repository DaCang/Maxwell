package com.syl.demo.util;
import java.io.Reader;

import com.syl.demo.dao.imp.UserDaoImp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;


public class MybatisUtil {
    public static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    static Logger logger = Logger.getLogger(MybatisUtil.class.getName());
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


        logger.info(sqlSessionFactory);
        return sqlSessionFactory.openSession();
    }


}

