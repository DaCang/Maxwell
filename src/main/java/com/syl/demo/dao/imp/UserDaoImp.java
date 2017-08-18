package com.syl.demo.dao.imp;

import com.syl.demo.action.SpringContextUtil;
import com.syl.demo.dao.UserDao;
import com.syl.demo.pojo.User;
import org.springframework.jdbc.core.JdbcTemplate;



public class UserDaoImp implements UserDao {




    private JdbcTemplate jdbcTemplate;



    @Override
    public Boolean findUser (User user) {
        jdbcTemplate = (JdbcTemplate) SpringContextUtil.getBean("jdbcTemplate");
        String sql = "SELECT count(*) FROM user where user_id='"+user.getUserName()+"'";
        int count = jdbcTemplate.queryForInt(sql);
        System.out.println(user.getUserName()+" queryForInt :"+count);
        return true;
    }
}
