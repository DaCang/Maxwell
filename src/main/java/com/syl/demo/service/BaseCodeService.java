package com.syl.demo.service;

import com.syl.demo.dao.imp.DeptDaoImp;
import com.syl.demo.dao.imp.RoleDaoImp;
import com.syl.demo.dao.imp.UserDaoImp;
import com.syl.demo.pojo.Dept;
import com.syl.demo.pojo.Role;
import com.syl.demo.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 一些基础数据的加载
 */
public class BaseCodeService extends  CommonService {

    DeptDaoImp deptDaoImp;
    RoleDaoImp roleDaoImp;
    private  final  String fileNameDept="deptBaseCode.json";
    private  final  String fileNameRole="roleBaseCode.json";


    public void work(){

        writeDeptBaseCode();
        writeRoleBaseCode();
    }
    public void writeDeptBaseCode(){

        List<Dept> deptList;
        deptDaoImp = new DeptDaoImp();//测试的时候打开
        Dept dept = new Dept();
        deptList = deptDaoImp.getDeptInfo(dept);
        String noticeStr = ObjectToJson(deptList);
        System.out.println(noticeStr);
        //String noticeStr = ObjectToJson(getNoticeObject ());
        FileUtil.writeTOFile( noticeStr,getPath(),fileNameDept);


    }
    public void writeRoleBaseCode(){


        List<Role> roleList;

        roleDaoImp = new RoleDaoImp();//测试时打开
        Role role = new Role();
        roleList = roleDaoImp.getRoleInfo(role);
        String roleStr = ObjectToJson(roleList);
        System.out.println(roleStr);
        //String noticeStr = ObjectToJson(getNoticeObject ());
        FileUtil.writeTOFile( roleStr,getPath(),fileNameRole);






    }
    public static String getPath(){
        File directory = new File("");// 参数为空
        String courseFile = null;
        try {
            courseFile = directory.getCanonicalPath().replace("bin","webapps")+"\\spring-demo-02\\notice\\";
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        //return courseFile;
        return "D:\\ideaWORK\\spring-demo-02\\src\\main\\webapp\\back\\json"; //IDEA下打开
    }
}
