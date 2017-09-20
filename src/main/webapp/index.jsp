<%--
  Created by IntelliJ IDEA.
  User: syl
  Date: 2017/8/14
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">
  <%-- <%String msg=(String)request.getSession().getAttribute("msg"); %> --%>
    <link rel="stylesheet" href="/jquery/jquery-ui.css">
    <script src="/jquery/jquery.js"></script>
    <script src="/jquery/jquery-ui.js"></script>

    <link rel="shortcut icon" type="image/x-icon" href="/favicon1.ico">

    <title>登陆首页</title>
  <style type="text/css">
    body
    {
      background: url('/welcome.jpg')fixed center no-repeat;
      background-size:100% 100%;
    }
  </style>
</head>

<body>
<div >
    <div >
        <div >
            <div >
            <form action="/loginAction.do" method="GET">
                <div >
                    <h3 >请登录</h3>
                </div>
                <div >
                    <label for="user_id" >用户名</label>
                    <input type="text" id="user_id"  name="user_id"  placeholder="用户名" required autofocus>
                </div>
                <div >
                    <label for="inputPassword" class="sr-only">密码</label>
                    <input type="password" id="inputPassword" name="password"  placeholder="密码" required>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me">
                        记住我
                    </label>
                </div>
                <p id="here" onclick="c()" >Here!</p>
                <button type="submit">登录</button>
            </form>
            </div>
        </div>
    </div>
</div>
<div id="dialog-form" title="创建新用户">
    <p class="validateTips">所有的表单字段都是必填的。</p>

    <form>
        <fieldset>
            <label for="name">名字</label>
            <input type="text" name="name" id="name" class="text ui-widget-content ui-corner-all">
            <label for="email">邮箱</label>
            <input type="text" name="email" id="email" value="" class="text ui-widget-content ui-corner-all">
            <label for="password">密码</label>
            <input type="password" name="password" id="password" value="" class="text ui-widget-content ui-corner-all">
        </fieldset>
    </form>
</div>
<di>
    <script src='https://gitee.com/JiaoWoMuMuJiuHao/codes/fs07hlr5bmoi8qtej4uv311/widget_preview?title=gistfile1.txt'></script>
</di>
</body>
</html>
