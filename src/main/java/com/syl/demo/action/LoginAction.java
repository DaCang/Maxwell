package com.syl.demo.action;



import com.syl.demo.pojo.User;
import com.syl.demo.service.LoginService;
import com.syl.demo.util.SpringContextUtil;
import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginAction.do")
public class LoginAction extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected Logger logger = Logger.getLogger(LoginAction.class);

    LoginService loginService ;



    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    /**
     * 表单提交
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {




    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user_id = request.getParameter("user_id");
        String passWord = request.getParameter("password");

        User u =loginService.findUser(user_id,passWord);
        if(u!=null){
            logger.info(u.getUserId()+" is exist!!");
            request.setAttribute("user",
                    u);
            //request.getRequestDispatcher("/login/loginSuccess.jsp").forward(request, response);
            request.getRequestDispatcher("back/index.jsp").forward(request, response);

        }else{
            String msg = user_id+" is not  exist!!";
            logger.info(msg);
            //response.setStatus(550);
            request.setAttribute("msg",
                    msg);
            request.getRequestDispatcher("/error/userNotExist.jsp").forward(request, response);
           // response.sendRedirect("/error/userNotExist.jsp");

        }



    }


    @Override
    public void init(ServletConfig config) throws ServletException {

        super.init(config);
        loginService=(LoginService) SpringContextUtil.getBean("loginService");
    }

}
