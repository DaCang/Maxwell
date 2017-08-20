package com.syl.demo.dao.imp;

import com.syl.demo.action.SpringContextUtil;
import com.syl.demo.dao.UserDao;
import com.syl.demo.pojo.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImp implements UserDao {


    User user;

    private JdbcTemplate jdbcTemplate;


    @Override
    public Boolean findUser (User u) {
        jdbcTemplate = (JdbcTemplate) SpringContextUtil.getBean("jdbcTemplate");
        String query_count_sql = "SELECT count(*) FROM user " +
                " where user_id='" + u.getUserId() + "' " +
                " and password='" + u.getPassWord() + "'  " +
                " AND  status = '0' ";

        int count = jdbcTemplate.queryForInt(query_count_sql);
        if (count != 1) {
            return false;
        }
        user=u;
        //System.out.println(u.getUserName() + " queryForInt :" + count);
        return true;
    }

    @Override
    public User getUserInfo () {
        String query_info_sql = "SELECT * FROM user " +
                " WHERE user_id=? " +
                " AND  status =? ";
        user = (User) jdbcTemplate.query(query_info_sql, new PreparedStatementSetter() {

            public void setValues (PreparedStatement ps) throws SQLException {
                ps.setString(1, user.getUserId());
                ps.setString(2, "0");

            }

            }, new ResultSetExtractor() {

            public Object extractData (ResultSet rs) throws SQLException, DataAccessException {

                while (rs.next()) {
                    user.setUserId(rs.getString("user_id"));
                    user.setUserName(rs.getString("user_name"));
                    user.setPassWord(rs.getString("password"));

                }
                return user;
            }
        });
        if (user == null) {
            return null;
        }


        return user;


    }

}
