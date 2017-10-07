package com.syl.demo.controller;

import com.syl.demo.action.UserAction;
import com.syl.demo.service.UserService;
import com.syl.demo.util.ResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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

}
