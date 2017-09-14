package com.syl.demo.action;

import com.syl.demo.service.DeptService;
import com.syl.demo.util.SpringContextUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deptAction.do")
public class DeptAction extends HttpServlet {
    DeptService deptService;
    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String deptInfo;
        String dept_id = req.getParameter("dept_id");
        String role_id = req.getParameter("role_id");
        deptInfo = deptService.getDeptInfoByRole(dept_id,role_id);

        System.out.println(deptInfo);

        resp.setContentType("text/plain;charset=UTF-8");
        resp.setContentType("text/plain; charset=gbk");
        resp.getWriter().print(deptInfo);
        resp.getWriter().flush();
        resp.getWriter().close();
    }

    @Override
    public void init () throws ServletException {
        super.init();
        deptService=(DeptService) SpringContextUtil.getBean("deptService");
    }
}
