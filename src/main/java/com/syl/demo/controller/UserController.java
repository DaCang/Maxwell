package com.syl.demo.controller;

import com.syl.demo.action.UserAction;
import com.syl.demo.pojo.Page;
import com.syl.demo.pojo.User;
import com.syl.demo.service.UserService;
import com.syl.demo.util.RequestUtil;
import com.syl.demo.util.ResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    protected Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    UserService userService ;

    @RequestMapping("/del")
    public @ResponseBody
    void del(HttpServletRequest request, Model model, String user_id,
               HttpServletResponse response) {


        String resultStr;
        if (userService.deleteUser(user_id)) {
            resultStr = user_id + " 删除成功！";
            logger.info("----------------------------------->" + resultStr +
                    "<-----------------------------------");
            ResponseUtil.setResponse(response, ResponseUtil.setCodeAndMsg(200, resultStr));
        } else {
            resultStr = user_id + " 删除失败！";
            logger.info("----------------------------------->" + resultStr +
                    "<-----------------------------------");
            ResponseUtil.setResponse(response, ResponseUtil.setCodeAndMsg(500, resultStr));

        }

    }

    @RequestMapping("/add")
    public void create (HttpServletRequest request, Model model, String user_id,
                        HttpServletResponse response) {
        String resultStr;
        User user = (User) RequestUtil.getObjectByRequest(request,User.class);
        // User user = getUserByRequest(request);
        if (userService.createUser(user)) {

            resultStr = user.getUserName() + " 创建成功！";
            logger.info(user.toString() + "\n" +
                    "----------------------------------->" + resultStr +
                    "<-----------------------------------");
            ResponseUtil.setResponse(response, ResponseUtil.setCodeAndMsg(200, resultStr));
        } else {
            resultStr = user.getUserName() + " 创建失败！";
            logger.info(user.toString() + "\n" +
                    "----------------------------------->" + resultStr +
                    "<-----------------------------------");
            ResponseUtil.setResponse(response, ResponseUtil.setCodeAndMsg(500, resultStr));
        }
    }
    @RequestMapping("/user_list")
    public void getUserInfoByPage (HttpServletRequest request, Model model, int page,
                        HttpServletResponse response) {

       // List<User> userList = userService.getUserInfoByPage1(page);

        //logger.info(userList);
        //ResponseUtil.setResponse(response,userInfo);
        //model.addAttribute("userList", userList);
        String userInfo = userService.getUserInfoByPage(page);

        logger.info(userInfo);
        ResponseUtil.setResponse(response,userInfo);
        //return "user_list";
    }

    /**
     *  加载部门,和权限下拉框
     * @param request
     * @param model
     * @param response
     * @return
     */
    @RequestMapping("/select_list")
    public String getSelectList (HttpServletRequest request, Model model,
                                     HttpServletResponse response) {



        List deptList = userService.getDeptList();
        List roleList = userService.getRoleList();

        System.out.println(deptList);
        System.out.println(roleList);
        model.addAttribute("deptList",deptList);
        model.addAttribute("roleList",roleList);

        return "user_add";
    }

    /**
     *  加载部门,和权限下拉框
     * @param request
     * @param model
     * @param response
     * @return
     */
    @RequestMapping("/pageCount")
    public  @ResponseBody
    Page pageCount (HttpServletRequest request, Model model,
                    HttpServletResponse response) {



      //int count=userService.pageCount();
        //model.addAttribute("pageCount",1);
        return userService.pageCount();
    }

}
