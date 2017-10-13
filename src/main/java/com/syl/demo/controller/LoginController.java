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
    public void   login(HttpServletRequest request, Model model,
               String user_id,String password,
               HttpServletResponse response)
    throws IOException{

        logger.info(user_id);
        logger.info(password);
        User u =loginService.findUser(user_id,password);
        if(u!=null){
            logger.info(u.getUserId()+" is exist!!");
            //model.addAttribute("user", u);
            request.setAttribute("user",
                    u);

            try {
                request.getRequestDispatcher("back/index.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }



        }else{
            String msg = user_id+" is not  exist!!";
            logger.info(msg);
            //response.setStatus(550);
            request.setAttribute("msg",
                    msg);

            try {
                request.getRequestDispatcher("/error/userNotExist.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
            // response.sendRedirect("/error/userNotExist.jsp");

        }
    }

}
