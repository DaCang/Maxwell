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
<script src="/jquery/jquery.js"></script>
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
        <p>

        </p>
    </div>
    <h3>部门管理</h3>
    <div>
        <p>

        </p>
    </div>
    <h3>通知管理</h3>
    <div>
        <p>

        </p>
    </div>
</div>
</body>
</html>
