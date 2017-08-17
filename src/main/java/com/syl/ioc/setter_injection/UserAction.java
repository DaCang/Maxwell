package com.syl.ioc.setter_injection;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserAction   extends HttpServlet {

    private ApplicationContext applicationContext;
    //@Resource (name = "user")
    User user;

    Food food;

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor of the object.
     */
    public UserAction() {
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
            String userName = request.getParameter("name");
            String foodName = request.getParameter("food");
            user.setUserName(userName);
            food.setFoodName(foodName);

            user.eating();
            food.eaten();


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


        try {
            super.init(config);
            applicationContext  = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
            user=(User) applicationContext.getBean("user");
            food=(Food) applicationContext.getBean("food");
        } catch (ServletException e1) {
            e1.printStackTrace();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        } catch (BeansException e3) {
            e3.printStackTrace();
        }catch (NullPointerException e4){
            e4.printStackTrace();
        }

    }

}
