<%--
  Created by IntelliJ IDEA.
  User: syl
  Date: 2017/9/21
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String user_id = (String) request.getAttribute("user_id");
    String role_id = (String) request.getAttribute("role_id");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
    <meta charset="UTF-8">
    <title>Lz_CMS-后台管理中心</title>
    <link rel="stylesheet" href="./layui/css/layui.css">
    <link rel="stylesheet" href="./css/global.css">
    <script src="/jquery/jquery.js"></script>
    <script type="text/javascript" src="./layui/layui.js"></script>
    <script type="text/javascript" src="./js/user.js"></script>
    <script>
        var user_id ='<%=user_id%>';
        var role_id ='<%=role_id%>';
        user_id="admin";
        role_id="system";
    </script>
</head>
<body>
<div class="layui-tab layui-tab-brief main-tab-container">
    <ul class="layui-tab-title main-tab-title">
        <a href="user_list.jsp"><li class="layui-this">账号列表</li></a>
        <a href="user_add.jsp"><li>添加账号</li></a>
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
                    <%--<tbody>
                    <tr>
                        <td>1</td>
                        <td>
                            学无止境
                        </td>
                        <td>文章模型</td>
                        <td style="text-align: center;">
                            <a href="./category_add.html" class="layui-btn layui-btn-small" title="编辑"><i class="layui-icon"></i></a>
                            <a class="layui-btn layui-btn-small layui-btn-danger del_btn" category-id="1" title="删除" category-name="学无止境"><i class="layui-icon"></i></a>
                        </td>
                    </tr>

                    </tbody>--%>
                    <tbody id="userInfo">

                    </tbody>
                    <thead>
                    <tr>
                        <th colspan="7"><button class="layui-btn layui-btn-small" lay-submit="" lay-filter="sort">排序</button></th>
                    </tr>
                    </thead>
                </table>

            </form>
        </div>
    </div>
</div>
<script type="text/javascript">
    layui.use(['element', 'layer', 'form'], function(){
        var element = layui.element()
            ,jq = layui.jquery
            ,form = layui.form()
            ,laypage = layui.laypage;

        //图片预览
        jq('.list-table td .thumb').hover(function(){
            jq(this).append('<img class="thumb-show" src="'+jq(this).attr('thumb')+'" >');
        },function(){
            jq(this).find('img').remove();
        });
        //链接预览
        jq('.list-table td .link').hover(function(){
            var link = jq(this).attr('href');
            layer.tips( link, this, {
                tips: [2, '#009688'],
                time: false
            });
        },function(){
            layer.closeAll('tips');
        });

        //监听提交
        form.on('submit(sort)', function(data){
            loading = layer.load(2, {
                shade: [0.2,'#000'] //0.2透明度的白色背景
            });
            var param = data.field;
            jq.post('',param,function(data){
                if(data.code == 200){
                    layer.close(loading);
                    layer.msg(data.msg, {icon: 1, time: 1000}, function(){
                        location.reload();//do something
                    });
                }else{
                    layer.close(loading);
                    layer.msg(data.msg, {icon: 2, anim: 6, time: 1000});
                }
            });
            return false;
        });

        //ajax删除
        jq('.del_btn').click(function(){
            var name = jq(this).attr('category-name');
            var id = jq(this).attr('category-id');
            layer.confirm('确定删除【'+name+'】?', function(index){
                loading = layer.load(2, {
                    shade: [0.2,'#000'] //0.2透明度的白色背景
                });
                jq.post('',{'id':id},function(data){
                    if(data.code == 200){
                        layer.close(loading);
                        layer.msg(data.msg, {icon: 1, time: 1000}, function(){
                            location.reload();//do something
                        });
                    }else{
                        layer.close(loading);
                        layer.msg(data.msg, {icon: 2, anim: 6, time: 1000});
                    }
                });
            });

        });

    })
</script>

</body>
</html>
