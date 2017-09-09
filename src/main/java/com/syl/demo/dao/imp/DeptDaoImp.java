package com.syl.demo.dao.imp;

import com.syl.demo.dao.DeptDao;
import com.syl.demo.pojo.Dept;
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

import static com.syl.demo.util.MybatisUtil.sqlSessionFactory;

public class DeptDaoImp implements DeptDao {

    static Logger logger = Logger.getLogger(UserDaoImp.class.getName());

    Dept dept;

    private JdbcTemplate jdbcTemplate;
    @Override
    public Dept getDeptInfo (String dept_id) {
        dept.setDeptId(dept_id);
        String query_info_sql = "SELECT * FROM dept " +
                " WHERE dept_id=? " ;
        dept = (Dept) jdbcTemplate.query(query_info_sql, new PreparedStatementSetter() {

            public void setValues (PreparedStatement ps) throws SQLException {
                ps.setString(1, dept.getDeptId());

            }

        }, new ResultSetExtractor() {

            public Object extractData (ResultSet rs) throws SQLException, DataAccessException {

                while (rs.next()) {
                    dept.setDeptId(rs.getString("dept_id"));
                    dept.setDeptName(rs.getString("dept_name"));
                    dept.setDeptUp(rs.getString(3));


                }
                return dept;
            }
        });
        if (dept == null) {
            return null;
        }


        return dept;

    }

    @Override
    public List<Dept> getAllDeptInfo () {
        return null;
    }


    @Override
    public boolean createDept (Dept dept) {
        return false;
    }

    public Dept getDept () {
        return dept;
    }

    public void setDept (Dept dept) {
        this.dept = dept;
    }

    public void setJdbcTemplate (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
