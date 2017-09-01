
<%--
  Created by IntelliJ IDEA.
  User: syl
  Date: 2017/8/18
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.syl.demo.pojo.User" %>
<%
    User user = (User) request.getSession().getAttribute("user");
%>
<html>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
    $( function() {
        $( "#tabs" ).tabs();
    } );
</script>

<style type="text/css">
    body
    {
        background: url('/welcome.jpg')fixed center no-repeat;
        background-size:100% 100%;
    }
    div#users-contain { width: 350px; margin: 20px 0; }
    div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
    div#users-contain table th { color: #32a5c4;background-color: #b2dba1;
    }
    div#users-contain table td, div#users-contain table th { border: 1px solid #ded6ee; padding: .6em 10px; text-align: left; }

</style>
<head>
    <title>loginSuccess</title>
</head>
<body>

<div >
<form >
    <h2 class="form-signin-heading">
        <font size="10px">欢迎,<strong><%=user.getUserName()%></strong>!</font>
    </h2>
</form>

</div> <!-- /container -->
<div id="tabs">
    <ul>
        <li><a href="#tabs-1">个人信息</a></li>
        <li><a href="#tabs-2">部门信息</a></li>
        <li><a href="#tabs-3">通知</a></li>
    </ul>
    <div id="tabs-1">
        <div id="users-contain" class="ui-widget">
            <table id="users" class="ui-widget ui-widget-content">
                <thead>
                    <tr class="ui-widget-header ">
                        <th>用户ID</th>
                        <th>用户名</th>
                        <th>密码</th>
                        <th>权限ID</th>
                    </tr>
                </thead>
                <tbody>
                    <td><%=user.getUserId()%></td>
                    <td><%=user.getUserName()%></td>
                    <td><%=user.getPassWord()%></td>
                    <td><%=user.getRoleId()%></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div id="tabs-2">
        <p>Morbi tincidunt, dui sit amet facilisis feugiat, odio metus gravida ante, ut pharetra massa metus id nunc. Duis scelerisque molestie turpis. Sed fringilla, massa eget luctus malesuada, metus eros molestie lectus, ut tempus eros massa ut dolor. Aenean aliquet fringilla sem. Suspendisse sed ligula in ligula suscipit aliquam. Praesent in eros vestibulum mi adipiscing adipiscing. Morbi facilisis. Curabitur ornare consequat nunc. Aenean vel metus. Ut posuere viverra nulla. Aliquam erat volutpat. Pellentesque convallis. Maecenas feugiat, tellus pellentesque pretium posuere, felis lorem euismod felis, eu ornare leo nisi vel felis. Mauris consectetur tortor et purus.</p>
    </div>
    <div id="tabs-3">
        <p>Mauris eleifend est et turpis. Duis id erat. Suspendisse potenti. Aliquam vulputate, pede vel vehicula accumsan, mi neque rutrum erat, eu congue orci lorem eget lorem. Vestibulum non ante. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Fusce sodales. Quisque eu urna vel enim commodo pellentesque. Praesent eu risus hendrerit ligula tempus pretium. Curabitur lorem enim, pretium nec, feugiat nec, luctus a, lacus.</p>
        <p>Duis cursus. Maecenas ligula eros, blandit nec, pharetra at, semper at, magna. Nullam ac lacus. Nulla facilisi. Praesent viverra justo vitae neque. Praesent blandit adipiscing velit. Suspendisse potenti. Donec mattis, pede vel pharetra blandit, magna ligula faucibus eros, id euismod lacus dolor eget odio. Nam scelerisque. Donec non libero sed nulla mattis commodo. Ut sagittis. Donec nisi lectus, feugiat porttitor, tempor ac, tempor vitae, pede. Aenean vehicula velit eu tellus interdum rutrum. Maecenas commodo. Pellentesque nec elit. Fusce in lacus. Vivamus a libero vitae lectus hendrerit hendrerit.</p>
    </div>
</div>
</body>
</html>
