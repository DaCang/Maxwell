package com.syl.demo.action;


import com.syl.demo.dao.UserDao;
import com.syl.demo.dao.imp.UserDaoImp;
import com.syl.demo.pojo.Role;
import com.syl.demo.pojo.User;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class UserAction extends HttpServlet {


    UserDaoImp userDao ;


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor of the object.
     */
    public UserAction () {
    }

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
        //user =  new User();
        String user_id = request.getParameter("user_id");
        String passWord = request.getParameter("password");
        User user=userDao.getUser();
        user.setUserId(user_id);
        user.setPassWord(passWord);
        if(userDao.findUser()){
            System.out.println(user_id+" is exist!!");
            user=userDao.getUserInfo();
            //request.setAttribute("user",user);
            request.getSession(false).setAttribute("user",
                    user);
            request.getRequestDispatcher("/login/loginSuccess.jsp").forward(request, response);
            //response.sendRedirect("/login/loginSuccess.jsp");
        }else{
            String msg = user_id+" is not  exist!!";
            System.out.println(msg);
            //response.setStatus(550);
            request.getSession(false).setAttribute("msg",
                    msg);
            response.sendRedirect("/error/userNotExist.jsp");

        }
        /*response.setContentType("text/plain;charset=UTF-8");
        response.setContentType("text/plain; charset=gbk");
        response.getWriter().print(true);
        response.getWriter().flush();
        response.getWriter().close();*/

    }

    /**
     * The doPost method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to post.
     *
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("--------");



    }

    /**
     * Initialization of the servlet. <br>
     *  此时就完成根据数据库配置文件对将要访问的数据库属性的配置(不一定对)
     * @throws ServletException if an error occurs
     * 第一次请求Servlet时，Servlet容器就会调用这个方法</br>
     * 在后续的请求中，将不再调用该方法</br>
     * 可以利用这个方法来编写一些应用程序初始化相关的代码
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        // Put your code here

        //DbResource r = new DbResource();
        //ServletContext sc=this.getServletContext();
        //r.getPropertie(sc);


        super.init(config);
       userDao=(UserDaoImp)SpringContextUtil.getBean("userDaoImp");
       //user=(User)SpringContextUtil.getBean("user");
        //role=(Role) applicationContext.getBean("role");

    }

}
