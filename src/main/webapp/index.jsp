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

  <title>首页</title>
</head>
<body>
<h1>Hello</h1>
<form name="f1" action="<%=basePath%>/userAction.do" method="get">
  姓名:<input type="text"  id="name" name="name"><br/>
  吃：
  <select name="food" id="food" >
    <option value="炸酱面">炸酱面</option>
    <option value="饺子">饺子</option>
  </select>
  <button value="go!" name="go" type="submit">go!</button>
</form>
</body>
</html>
