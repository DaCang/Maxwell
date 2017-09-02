package com.syl.demo.pojo;

public class Notice {

    String noticeId;

    String noticeTime;

    String noticeTitle;

    String noticeContent;

    String issueUser;

    String execUser;

    String isExec;

    String execTime;

    String execRemark;

    public String getNoticeId () {
        return noticeId;
    }

    public void setNoticeId (String noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeTime () {
        return noticeTime;
    }

    public void setNoticeTime (String noticeTime) {
        this.noticeTime = noticeTime;
    }

    public String getNoticeTitle () {
        return noticeTitle;
    }

    public void setNoticeTitle (String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeContent () {
        return noticeContent;
    }

    public void setNoticeContent (String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getIssueUser () {
        return issueUser;
    }

    public void setIssueUser (String issueUser) {
        this.issueUser = issueUser;
    }

    public String getExecUser () {
        return execUser;
    }

    public void setExecUser (String execUser) {
        this.execUser = execUser;
    }

    public String getIsExec () {
        return isExec;
    }

    public void setIsExec (String isExec) {
        this.isExec = isExec;
    }

    public String getExecTime () {
        return execTime;
    }

    public void setExecTime (String execTime) {
        this.execTime = execTime;
    }

    public String getExecRemark () {
        return execRemark;
    }

    public void setExecRemark (String execRemark) {
        this.execRemark = execRemark;
    }

    @Override
    public String toString () {
        return "Notice{" +
                "noticeId='" + noticeId + '\'' +
                ", noticeTime='" + noticeTime + '\'' +
                ", noticeTitle='" + noticeTitle + '\'' +
                ", noticeContent='" + noticeContent + '\'' +
                ", issueUser='" + issueUser + '\'' +
                ", execUser='" + execUser + '\'' +
                ", isExec='" + isExec + '\'' +
                ", execTime='" + execTime + '\'' +
                ", execRemark='" + execRemark + '\'' +
                '}';
    }
}
