<%--
  Created by IntelliJ IDEA.
  User: syl
  Date: 2017/9/4
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="/jquery/jquery-ui.css">
<link rel="stylesheet" href="/res/layui/css/layui.css"  media="all">
<script src="/jquery/jquery.js"></script>
<script src="/res/layui/layui.js"></script>
<script src="/jquery/jquery-ui.js"></script>
<script>
    $(function() {
        $( "#accordion" ).accordion(
            {
                collapsible: true,//是否折叠
                active:0,//默认打开第一个折叠面板
                heightStyle: "content",//高度自适应
                header: "h3"//指定标题
            }
        );


    })
function  tips() {

    layui.use('layer', function () {
        var layer = layui.layer;
        layer.tips('Hi，我是tips', '#id');
    });


}

</script>
<style>
    #toggle {
        width: 300px;
        height: 200px;
        background: #ccc;
    }
</style>
<head>
    <title>Title</title>
</head>
<body>
<div id="accordion"  class="ui-widget-content">
    <h3>用户管理</h3>
    <div>
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>用户管理</legend>
        </fieldset>
        <form  class="layui-form" action="/userAction.do?method=add" style="width: 35%">


            <%--userId, userName, passWord, roleId, status, deptId--%>
            <div class="layui-form-item">
                <label class="layui-form-label">用户ID</label>
                <div class="layui-input-block">
                    <input type="text" name="title" id="id" lay-verify="title" autocomplete="off" placeholder="用户ID" class="layui-input" onclick="tips()">
                </div>
            </div>
            <table>
                <tr>
                    <th>用户ID</th>
                    <td width="245"><input id="user_id" name="user_id" required></td>
                    <td></td>
                </tr>
                <tr>
                    <th>用户姓名</th>
                    <td width="245"><input id="user_name" name="user_name" required></td>
                    <td></td>
                </tr>
                <tr>
                    <th>用户密码</th>
                    <td width="245"><input id="password" name="password"  type="password" required></td>
                    <td></td>
                </tr>
                <tr>
                    <th>用户密码</th>
                    <td width="245"><input id="password1" name="password1"  type="password" required value="再次确认"></td>
                    <td></td>
                </tr>
                <tr>
                    <th>用户权限</th>
                    <td width="245"><input id="password2" name="password2"  type="password" required value="再次确认"></td>
                    <td></td>
                </tr>


                <tr>
                    <th></th>
                    <td width="245"><input  type="submit" value="ADD"></td>
                    <td></td>
                </tr>
            </table>
        </form>
    </div>
    <h3>部门管理</h3>
    <div>
        <p>
            部门管理
        </p>
    </div>
    <h3>通知管理</h3>
    <div>
        <p>
            通知管理
        </p>
    </div>
</div>
</body>
</html>
