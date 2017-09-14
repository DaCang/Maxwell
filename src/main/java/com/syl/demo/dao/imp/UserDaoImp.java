package com.syl.demo.dao.imp;

import com.syl.demo.dao.DeptDao;
import com.syl.demo.dao.UserDao;
import com.syl.demo.pojo.Dept;
import com.syl.demo.pojo.User;
import com.syl.demo.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class UserDaoImp implements UserDao {


    static Logger logger = Logger.getLogger(UserDaoImp.class.getName());
    User user;

    private JdbcTemplate jdbcTemplate;



    public Boolean findUser (User user) {
        String query_count_sql = "SELECT count(*) FROM user " +
        " where user_id='" + user.getUserId() + "' " +
                " and password='" + user.getPassWord() + "'  " +
                " AND  status = '0' ";

        int count = jdbcTemplate.queryForInt(query_count_sql);
        if (count != 1) {
            return false;
        }
        logger.debug(user.toString());
        return true;
    }

    @Override
    public Boolean findUser () {
        return true;
    }

    @Override
    public List<User> getUserInfo (User user) {
        SqlSession session = null;
        List<User> userList;
        try {


            session = MybatisUtil.getSession();
            UserDao userDao = session.getMapper(UserDao.class);
            userList = userDao.getUserInfo(user);
        } finally {
            session.close();
        }
        return userList;
    }

    /*@Override
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
                    user.setRoleId(rs.getString("role_ids"));
                    user.setDeptId(rs.getString("dept_id"));

                }
                return user;
            }
        });
        if (user == null) {
            return null;
        }


        return user;


    }
*/
    public User getUser () {
        return user;
    }

    public void setUser (User user) {
        this.user = user;
    }


    public void setJdbcTemplate (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void main (String[] args) {
        String version= System.getProperty("java.version");
        System.out.println(version);
    }

}
