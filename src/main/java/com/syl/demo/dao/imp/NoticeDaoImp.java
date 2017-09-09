package com.syl.demo.dao.imp;

import com.syl.demo.dao.DeptDao;
import com.syl.demo.dao.NoticeDao;
import com.syl.demo.pojo.Dept;
import com.syl.demo.pojo.Notice;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class NoticeDaoImp implements NoticeDao {

    static Logger logger = Logger.getLogger(UserDaoImp.class.getName());



    private JdbcTemplate jdbcTemplate;

    @SuppressWarnings("unchecked")
    public List<Notice> getNoticeObject () {

        SqlSession session = null;
        List<Notice> notice ;
        try {

            session = MybatisUtil.getSession();
            NoticeDao noticeDao =  session.getMapper(NoticeDao.class);
            notice =noticeDao.getNoticeObject();
            System.out.println(notice.toString());
           /* Dept d = new Dept();
            d.setDeptId("20170909001");
            d.setDeptName("第一支部一分部");
            d.setDeptUp("20170909");
            deptDao.createDept(d);
            session.commit();*/

        } finally {
            session.close();
        }
        return notice;
//        String query_info_sql = "SELECT * FROM notice " ;
//        List<Notice> noticeList;
//        noticeList = (List) jdbcTemplate.query(query_info_sql, new PreparedStatementSetter() {
//
//            public void setValues (PreparedStatement ps) throws SQLException {
//
//
//            }
//
//        }, new ResultSetExtractor() {
//
//            public Object extractData (ResultSet rs) throws SQLException, DataAccessException {
//                List<Notice> tempList = new ArrayList<>();
//                while (rs.next()) {
//
//                    Notice notice = new Notice();
//                    notice.setNoticeId(rs.getString(1));
//                    notice.setNoticeTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").
//                                            format(rs.getTimestamp(2)));
//                    notice.setNoticeTitle(rs.getString(3));
//                    notice.setNoticeContent(rs.getString(4));
//                    notice.setIssueUser(rs.getString(5));
//                    notice.setExecUser(rs.getString(6));
//                    notice.setIsExec(rs.getString(7));
//                    notice.setExecTime(rs.getString(8));
//                    notice.setExecRemark(rs.getString(9));
//                    tempList.add(notice);
//                }
//                return tempList;
//            }
//        });
//    return  noticeList;
    }





    public void setJdbcTemplate (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void main (String[] args) {


            }



}
