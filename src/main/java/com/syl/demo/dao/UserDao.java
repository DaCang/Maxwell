package com.syl.demo.dao;


import com.syl.demo.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public interface UserDao extends  BaseDao {


    Boolean findUser();

    //User getUserInfo();

    List<User> getUserInfo(User user);

    int createUser(User user);

    int deleteUser(User user);

    List<User> getUserInfoByPage(@Param("start") int start,@Param("row_count") int row_count );


}
