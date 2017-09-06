package com.syl.demo.pojo;


//@Component(value = "user")
public class User {


    String userId;


    String userName;

    String passWord;

    String status;

    String roleId;

    String deptId;


    public User () {
    }


    public String getUserId () {
        return userId;
    }

    public void setUserId (String userId) {
        this.userId = userId;
    }

    public String getStatus () {
        return status;
    }

    public void setStatus (String status) {
        this.status = status;
    }

    public String getUserName () {
        return userName;
    }


    public void setUserName (String userName) {
        this.userName = userName;
    }

    public String getPassWord () {
        return passWord;
    }

    public void setPassWord (String passWord) {
        this.passWord = passWord;
    }

    public String getRoleId () {
        return roleId;
    }

    public void setRoleId (String roleId) {
        this.roleId = roleId;
    }


    public String getDeptId () {
        return deptId;
    }

    public void setDeptId (String deptId) {
        this.deptId = deptId;
    }
}
