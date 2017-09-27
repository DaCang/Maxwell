<%--
  Created by IntelliJ IDEA.
  User: syl
  Date: 2017/8/16
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%
    String  msg = (String) request.getAttribute("msg");
%>
<html>
<style type="text/css">
    body
    {
        background: url('/error.jpg')fixed center no-repeat;
        background-size:85% 85%;
    }
</style>
<head>
    <title>Error Page For Examples</title>
</head>
<body bgcolor="white" alink="#f5f5dc" >
    <h1 align="center" style="color:red;"><%=msg%></h1>
    <p title="500"  align="right" style="width: 100%; ">
        <font size="10px"><strong>please try <a href='/index.html' title="index.jsp">again</a>.</strong></font>
    </p>
</body>
</html>

<!-- a padding to disable MSIE and Chrome friendly error page -->
<!-- a padding to disable MSIE and Chrome friendly error page -->

