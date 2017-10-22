package com.syl.demo.pojo;

public class Dept {
    String deptId;

    String deptName;

    String deptUp;

    public String getDeptId () {
        return deptId;
    }

    public void setDeptId (String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName () {
        return deptName;
    }

    public void setDeptName (String deptName) {
        this.deptName = deptName;
    }

    public String getDeptUp () {
        return deptUp;
    }

    public void setDeptUp (String deptUp) {
        this.deptUp = deptUp;
    }


    /**
     * 增加toString()方法
     * @return
     */
    @Override
    public String toString () {
        return "Dept{" +
                "deptId='" + deptId + '\'' +
                ", deptName='" + deptName + '\'' +
                ", deptUp='" + deptUp + '\'' +
                '}';
    }
}
