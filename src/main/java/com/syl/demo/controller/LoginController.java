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

/**
 * 登陆Controller
 * @author syl
 */
@Controller
public class LoginController {

    private static final long serialVersionUID = 1L;

    protected Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    LoginService loginService ;

 /**
   * 用户登陆
   * @Title:login
   * @Description: （用户登陆）
   * @param user
   * @return
   * @author 宋永利
   * @date 2018/3/10
   * @throws
  */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String   login(HttpServletRequest request, Model model, User user, HttpServletResponse response){
        String msg =user.getUserId();
        logger.info("user login..."+user.toString());
        User u =loginService.findUser(user);
        msg += (u!=null)?" is exist!!":" is not  exist!!";
        model.addAttribute("user", u);
        model.addAttribute("msg", msg);
        logger.info(msg);
        return (u!=null)?"index":"userNotExist";
    }

}
