package com.syl.demo.controller;

import com.syl.demo.pojo.User;
import com.syl.demo.service.LoginService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller

public class LoginController {

    private static final long serialVersionUID = 1L;

    protected Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    LoginService loginService ;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String   login(HttpServletRequest request, Model model,
               User user,
               HttpServletResponse response)
    throws IOException{

        logger.info(user.getUserId());
        logger.info(user.getPassword());
        User u =loginService.findUser(user);
        if(u!=null){
            logger.info(u.getUserId()+" is exist!!");
            model.addAttribute("user", u);
            return "index";

        }else{
            String msg = user.getUserId()+" is not  exist!!";
            logger.info(msg);
            model.addAttribute("msg", msg);
            return "userNotExist";

        }
    }

}
