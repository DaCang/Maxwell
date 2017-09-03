package com.syl.demo.dao.imp;

import com.alibaba.fastjson.JSON;
import com.syl.demo.dao.NoticeDao;
import com.syl.demo.pojo.Notice;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class NoticeDaoImp implements NoticeDao {

    static Logger logger = Logger.getLogger(UserDaoImp.class.getName());
    Notice notice;

    private JdbcTemplate jdbcTemplate;
    @Override
    public void getNoticeObject () {
        String query_info_sql = "SELECT * FROM notice " ;
        notice = (Notice) jdbcTemplate.query(query_info_sql, new PreparedStatementSetter() {

            public void setValues (PreparedStatement ps) throws SQLException {


            }

        }, new ResultSetExtractor() {

            public Object extractData (ResultSet rs) throws SQLException, DataAccessException {

                while (rs.next()) {


                    notice.setNoticeId(rs.getString(1));
                    notice.setNoticeTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").
                                            format(rs.getTimestamp(2)));
                    notice.setNoticeTitle(rs.getString(3));
                    notice.setNoticeContent(rs.getString(4));
                    notice.setIssueUser(rs.getString(5));
                    notice.setExecUser(rs.getString(6));
                    notice.setIsExec(rs.getString(7));
                    notice.setExecTime(rs.getString(8));
                    notice.setExecRemark(rs.getString(9));

                }
                return notice;
            }
        });

    }

    @Override
    public String getNoticeStr ()
    {
        System.out.println(JSON.toJSONString(notice));
        logger.info(JSON.toJSONString(notice));
        return null;
    }


    public void setNotice (Notice notice) {
        this.notice = notice;
    }


    public void setJdbcTemplate (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
