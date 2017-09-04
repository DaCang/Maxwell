
<%--
  Created by IntelliJ IDEA.
  User: syl
  Date: 2017/8/18
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.syl.demo.pojo.User" %>
<%@ page import="com.syl.demo.pojo.Dept" %>
<%
    User user = (User) request.getSession().getAttribute("user");
    Dept dept = (Dept) request.getSession().getAttribute("dept");
%>
<html>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/jquery/jquery-ui.css">
<script src="/jquery/jquery.js"></script>
<script src="/jquery/jquery-ui.js"></script>
<script>
    $(function() {
        $( "#tabs" ).tabs({
            cache:false,        //是否缓存远程tab内容，默认为false
            event:"mouseover",      //切换条件，也可以设为mouseover，hover
            collapsible:true,   //再次点击，可折叠选项卡
            collapsible:true,   //设置为true时将设置一个选中的tab再此被选中时执行反选操作
            fx:{ opacity: 'toggle'},    //在隐藏或者显示面板的时候开启动画
            selected:0,         //从0开始的序列值,设置第几个tab将在初始化时被选中. 设置为-1则不选中所有tab.
            beforeLoad:function(event,ui){
                //当远程加载失败时加载的函数
                ui.jqXHR.error(function(){
                    ui.panel.html("暂时不能加载内容...");
                });
            },
            //这个事件在点击一个tab的时候触发
            select:function(event,ui){

                alert(111);
            }
        });
        var role = '<%=user.getRoleId()%>'
        //alert(role);
        if(role.indexOf("system") >= 0){
            $("#manager").show()
        }else{
            $("#manager").hide()
        }
    });
</script>

<style type="text/css">
    body
    {
        background: url('/welcome.jpg')fixed center no-repeat;
        background-size:100% 100%;
    }
    div#users-info ,div#dept-info { width: 350px; margin: 20px 0; }
    div#users-info table ,div#dept-info table{ margin: 1em 0; border-collapse: collapse; width: 100%; }
    div#users-info table th  ,div#dept-info table th { color: #32a5c4;background-color: #b2dba1;
    }
    div#users-info table td ,div#dept-info table td, div#dept-info table th, div#users-info table th { border: 1px solid #ded6ee; padding: .6em 10px; text-align: left; }

</style>
<head>
    <title>loginSuccess</title>
</head>
<body>

<div >
<form >
    <h2 class="ui-corner-right">
        <p>欢迎</p><strong><%=user.getUserName()%>(<%=dept.getDeptName()%>)</strong>!
    </h2>
</form>

</div> <!-- /container -->
<div id="tabs">
    <ul>
        <li><a href="#tabs-1">个人信息</a></li>
        <li><a href="#tabs-2">部门信息</a></li>
        <li><a href="notice/notice.html">通知</a></li>
        <li id="manager"><a href="back/manager.jsp">后台管理</a></li>
    </ul>
    <div id="tabs-1">
        <div id="users-info" class="ui-widget">
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
                    <td><%=user.getRoleId()!=null?user.getRoleId():""%></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div id="tabs-2">
        <div id="dept-info" class="ui-widget">
            <table id="dept" class="ui-widget ui-widget-content">
                <thead>
                <tr class="ui-widget-header ">
                    <th>部门ID</th>
                    <th>部门名称</th>
                    <th>上级部门</th>
                </tr>
                </thead>
                <tbody>
                <td><%=dept.getDeptId()%></td>
                <td><%=dept.getDeptName()%></td>
                <td><%=dept.getDeptUp()!=null?dept.getDeptUp():""%></td>
                </tr>
                </tbody>
            </table>
        </div>

    </div>
    <%--<div id="tabs-3">
        <p>Mauris eleifend est et turpis. Duis id erat. Suspendisse potenti. Aliquam vulputate, pede vel vehicula accumsan, mi neque rutrum erat, eu congue orci lorem eget lorem. Vestibulum non ante. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Fusce sodales. Quisque eu urna vel enim commodo pellentesque. Praesent eu risus hendrerit ligula tempus pretium. Curabitur lorem enim, pretium nec, feugiat nec, luctus a, lacus.</p>
        <p>Duis cursus. Maecenas ligula eros, blandit nec, pharetra at, semper at, magna. Nullam ac lacus. Nulla facilisi. Praesent viverra justo vitae neque. Praesent blandit adipiscing velit. Suspendisse potenti. Donec mattis, pede vel pharetra blandit, magna ligula faucibus eros, id euismod lacus dolor eget odio. Nam scelerisque. Donec non libero sed nulla mattis commodo. Ut sagittis. Donec nisi lectus, feugiat porttitor, tempor ac, tempor vitae, pede. Aenean vehicula velit eu tellus interdum rutrum. Maecenas commodo. Pellentesque nec elit. Fusce in lacus. Vivamus a libero vitae lectus hendrerit hendrerit.</p>
    </div>--%>
</div>
</body>
</html>
