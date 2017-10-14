package com.syl.demo.service;

import com.syl.demo.dao.DeptDao;
import com.syl.demo.dao.RoleDao;
import com.syl.demo.dao.UserDao;
import com.syl.demo.pojo.Dept;
import com.syl.demo.pojo.Page;
import com.syl.demo.pojo.Role;
import com.syl.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends  CommonService {


    @Autowired
    UserDao userDao;

    @Autowired
    DeptDao  deptDao;

    @Autowired
    RoleDao roleDao;

    @Autowired
    Page page;

    public String getUserInfo(String user_id,String role_id){
        //userDaoImp = new UserDaoImp();//测试的时候打开
        List userList;
        User user ;
        user =  new User();
        user.setUserId(user_id);
        if(!role_id.contains("system")){//如果不是system,只查询本人信息
            user.setRoleId(role_id);
        }
        userList = userDao.getUserInfo(user);//根据user_id查询用户信息

        return ObjectToJson(userList);
    }

    public boolean createUser (User user) {
       // userDaoImp = new UserDaoImp();//测试的时候打开
        int res =userDao.createUser(user);
        if(res>0){
            System.out.println("插入成功！"+res+"行受影响！");
            return true;
        }
        return false;
    }
    public boolean deleteUser (String user_id) {
        //userDaoImp = new UserDaoImp();//测试的时候打开
        User user = new User();
        user.setUserId(user_id);
        int res =userDao.deleteUser(user);
        if(res>0){
            System.out.println("删除成功！"+res+"行受影响！");
            return true;
        }
        return false;
    }


    public  List<User> getUserInfoByPage1(int page){
       // userDaoImp = new UserDaoImp();//测试的时候打开
        List userList;
        int aPagSize=5;
        int start=0;
        int end=0;
        start=(page-1)*aPagSize;
        end=aPagSize;

       // userList = userDaoImp.getUserInfoByPage(start,end);//根据user_id查询用户信息

        //return ObjectToJson(userList);
        return userDao.getUserInfoByPage(start,end);

    }
    public  String getUserInfoByPage(int page){
        // userDaoImp = new UserDaoImp();//测试的时候打开
        List userList;
        int aPagSize=5;
        int start=0;
        int end=0;
        start=(page-1)*aPagSize;
        end=aPagSize;

         userList = userDao.getUserInfoByPage(start,end);//根据user_id查询用户信息

        return ObjectToJson(userList);
    }

    @Override
    public String ObjectToJson (Object object) {
        return super.ObjectToJson(object);
    }


    public List<Dept>  getDeptList(){

        return deptDao.findAllList();
    }
    public List<Role>  getRoleList(){

        return roleDao.findAllList();
    }

    public Page pageCount(){
        return userDao.pageCount();
    }

    public static void main (String[] args) {
        System.out.println(6%5);
    }
}
