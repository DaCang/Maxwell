package com.syl.demo.action;


import com.syl.demo.pojo.User;
import com.syl.demo.service.UserService;
import com.syl.demo.util.SpringContextUtil;
import org.apache.log4j.Logger;
import org.omg.CORBA.Object;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UserAction extends HttpServlet {


    protected Logger logger = Logger.getLogger(UserAction.class);


    UserService userService ;

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
     * 表单提交  已经经过登陆验证的表单提交
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String user_id = request.getParameter("user_id");
            String role_id = request.getParameter("role_id");
            String userInfo = userService.getUserInfo(user_id,role_id);

            logger.info(userInfo);
           /* response.setContentType("text/plain;charset=UTF-8");
            response.setContentType("text/plain; charset=gbk");
            response.getWriter().print(userInfo);
            response.getWriter().flush();
            response.getWriter().close();*/
            setResponse(response,userInfo);


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
        String method = request.getParameter("method");
        String user_id = request.getParameter("user_id");
        String resultStr;
        if(method==null||"".equals(method)){
            resultStr  = "服务器错误,请联系管理员";
            logger.info("后台方法跳转失败\n" +
                    "----------------------------------->"+resultStr+
                    "<-----------------------------------");
            setResponse(response,setCodeAndMsg(404,resultStr));
            return;
        }

        if("add".equals(method)) {
            User user = getUserByRequest(request);
            if (userService.createUser(user)) {

                resultStr = user.getUserName() + " 创建成功！";
                logger.info(user.toString() + "\n" +
                        "----------------------------------->" + resultStr +
                        "<-----------------------------------");
                setResponse(response, setCodeAndMsg(200, resultStr));
            } else {
                resultStr = user.getUserName() + " 创建失败！";
                logger.info(user.toString() + "\n" +
                        "----------------------------------->" + resultStr +
                        "<-----------------------------------");
                setResponse(response, setCodeAndMsg(500, resultStr));
            }
        }else if ("delete".equals(method)) {

            if (userService.deleteUser(user_id)) {
                resultStr = user_id + " 删除成功！";
                logger.info("----------------------------------->" + resultStr +
                          "<-----------------------------------");
                setResponse(response, setCodeAndMsg(200, resultStr));
            } else {
                resultStr = user_id + " 删除失败！";
                logger.info("----------------------------------->" + resultStr +
                        "<-----------------------------------");
                setResponse(response, setCodeAndMsg(500, resultStr));

            }

            setResponse(response, setCodeAndMsg(500, "hello"));
        }



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

        super.init(config);
        userService=(UserService) SpringContextUtil.getBean("userService");


    }

    public User getUserByRequest(HttpServletRequest request){
        String user_id = request.getParameter("user_id");
        String user_name = request.getParameter("user_name");
        String password = request.getParameter("password");
        String dept_id = request.getParameter("dept_id");
        String role_id = request.getParameter("role_id");
        User user = new User();
        user.setUserId(user_id);
        user.setUserName(user_name);
        user.setPassWord(password);
        user.setDeptId(dept_id);
        user.setRoleId(role_id);
        user.setStatus("0");
        return user;
    }

    public  void setResponse(HttpServletResponse response, String jsonStr){

        try {
            response.setContentType("text/plain;charset=UTF-8");
            response.setContentType("text/plain; charset=gbk");
            response.getWriter().print(jsonStr);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                response.setContentType("text/html; charset=gbk");

                response.getWriter().print(
                        "{\"code\":\"500\" , \"msg\":\""
                                + replaceBlank(e.getMessage()).replaceAll("\"",
                                "") + "\" }");
                response.getWriter().flush();
                response.getWriter().close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

    }

    private String setCodeAndMsg(int code,String msg){
        return "{\"code\":\""+code+"\",\"msg\":\""+msg+"\"}";

    }
    private String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

}
