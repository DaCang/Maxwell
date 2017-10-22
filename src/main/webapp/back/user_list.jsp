<%--
  Created by IntelliJ IDEA.
  User: syl
  Date: 2017/9/21
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String user_id = (String) request.getAttribute("user_id");
    String role_id = (String) request.getAttribute("role_id");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
    <meta charset="UTF-8">
    <title>Lz_CMS-后台管理中心</title>
    <link rel="stylesheet" href="/back/static/layui/css/layui.css">
    <link rel="stylesheet" href="/back/static/css/global.css">
    <script src="/jquery/jquery.js"></script>
    <script type="text/javascript" src="/back/static/layui/layui.js"></script>
    <script type="text/javascript" src="/back/static/js/user.js"></script>
    <script>
        /*
* 获取用户信息
* */
        function setData(data,page) {
            // alert(data);
            var userInfoHtml = "";
            var userInfo = $("#userInfo")

            //var list = eval("["+data+"]");
            var  list=data.list;
            //alert(list.length)
            for(var i=0;i<list.length;i++){
                //alert(list[i].userId)
              userInfoHtml = userInfoHtml+
                    "<tr>" +
                    "<td>"+(i+1+(page-1)*5)+"</td>" +
                    "<td>"+list[i].userId+"</td>" +
                    "<td>"+list[i].userName+"</td>" +
                    "<td>"+list[i].password+"</td>" +
                    "<td>"+getRoleName(list[i].roleId)+"</td>" +
                    "<td>"+list[i].deptId+"</td>" +
                    " <td style=\"text-align: center;\">\n" +
                    " <a href=\"./category_add.html\" class=\"layui-btn layui-btn-small\" title=\"编辑\"><i class=\"layui-icon\"></i></a>\n" +
                    " <a  class=\"del_btn layui-btn layui-btn-small layui-btn-danger \"  onclick='del(this)' user-id=\""+list[i].userId+"\" title=\"删除\" user-name=\""+list[i].userName+"\"><i class=\"layui-icon\"></i></a>\n" +
                    "  </td>" +
                    "</tr>";
            }
            console.log(userInfoHtml)
            userInfo.html(userInfoHtml);//显示处理后的数据
        }

    </script>
</head>
<body>
<div class="layui-tab layui-tab-brief main-tab-container">
    <ul class="layui-tab-title main-tab-title">
        <a href="user_list.jsp"><li class="layui-this">账号列表</li></a>
        <a href="/user/select_list.con"><li>添加账号</li></a>
        <div class="main-tab-item">账号管理</div>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <form class="layui-form">

                <table class="list-table">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>用户ID</th>
                        <th>用户姓名</th>
                        <th>用户密码</th>
                        <th>用户权限</th>
                        <th>用户部门</th>
                        <th>操作</th>
                    </tr>
                    </thead>

                    <tbody id="userInfo">

                   <%-- <c:forEach items="${userList}" var="list"  varStatus="count">
                        <tr >
                            <td>${count.count}</td>
                            <td>${list.userId}</td>
                            <td>${list.userName}</td>

                            <td>${list.password}</td>
                          &lt;%&ndash; <c:if  test="${list.roleId=='system'}">
                                <td>系统管理员</td>
                            </c:if>&ndash;%&gt;

                            <c:choose>
                                <c:when test="${list.roleId== 'system'}">
                                    <td>系统管理员</td>
                                </c:when>
                                <c:when test="${list.roleId== '001'}">
                                    <td>普通用户</td>
                                </c:when>
                            </c:choose>
                            &lt;%&ndash;<td>${list.roleId}</td>&ndash;%&gt;
                            <td>${list.deptId}</td>
                            <td>0</td>

                        </tr>
                    </c:forEach>--%>
                    </tbody>
                    <thead>
                    <tr>
                        <th ><button class="layui-btn layui-btn-small" lay-submit="" lay-filter="sort">排序</button></th>
                        <th colspan="6"><div id="page"></div></th>
                    </tr>
                    </thead>
                </table>

            </form>
        </div>
    </div>
</div>


</body>
</html>
