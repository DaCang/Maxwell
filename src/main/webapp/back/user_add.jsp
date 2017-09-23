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
<html>
<head>
  <meta charset="UTF-8">
  <title>Lz_CMS-后台管理中心</title>
  <link rel="stylesheet" href="./layui/css/layui.css">
  <link rel="stylesheet" href="./css/global.css">
  <script src="/jquery/jquery.js"></script>
  <script type="text/javascript" src="./layui/layui.js"></script>
  <script type="text/javascript" src="./js/user_add.js"></script>
  <script>
      var user_id ='<%=user_id%>';
      var role_id ='<%=role_id%>';
      user_id="admin";
      role_id="system";
  </script>
</head>
<body>
<div class="layui-tab-brief main-tab-container" >
    <ul class="layui-tab-title main-tab-title">
      <a href="user_list.jsp"><li>账号列表</li></a>
      <a href="user_add.jsp"><li class="layui-this">添加账号</li></a>
      <div class="main-tab-item">账号管理</div>
    </ul>
    <div class="layui-tab-content">
      <div class="layui-tab-item layui-show">
        <form class="layui-form">
          <div class="layui-tab layui-tab-card">
            <ul class="layui-tab-title">
              <li class="layui-this">登陆信息</li>
              <li>账号设置</li>
            </ul>
            <div class="layui-tab-content">

              <%--登陆信息  begin--%>
              <div  id="login_info" class="layui-tab-item layui-show" >

                <div class="layui-form-item">
                  <label class="layui-form-label">登陆账号</label>
                  <div class="layui-input-inline input-custom-width">
                    <input type="text" id="user_id" name="user_id" value="" lay-verify="required" autocomplete="off"
                           placeholder="请输入登陆账号" class="layui-input">
                  </div>
                </div>
                <div class="layui-form-item">
                  <label class="layui-form-label">账号昵称</label>
                  <div class="layui-input-inline input-custom-width">
                    <input type="text" id="user_name" name="user_name" value="" lay-verify="required" autocomplete="off"
                           placeholder="请输入账号昵称" class="layui-input">
                  </div>
                </div>
                <div class="layui-form-item">
                  <label class="layui-form-label">账号密码</label>
                  <div class="layui-input-inline input-custom-width">
                    <input type="text" id="password" name="password" value="" lay-verify="required" autocomplete="off"
                           placeholder="请输入账号密码" class="layui-input">
                  </div>
                </div>
                <div class="layui-form-item">
                  <label class="layui-form-label">再次确认</label>
                  <div class="layui-input-inline input-custom-width">
                    <input type="text" id="password_again" name="password_again" value="" lay-verify="required" autocomplete="off"
                           placeholder="请输入账号密码,再次确认" class="layui-input">
                  </div>
                </div>


                <div class="layui-form-item">
                  <label class="layui-form-label">所在部门</label>
                  <div class="layui-input-inline input-custom-width">
                    <select id="dept_id" name="dept_id" lay-verify="">


                    </select>

                  </div>
                  <div class="layui-form-mid layui-word-aux"></div>
                </div>

                <div class="layui-form-item">
                  <label class="layui-form-label">权限设置</label>
                  <div class="layui-input-inline input-custom-width">
                    <select  id="role_id" name="role_id" lay-verify="">

                    </select>
                  </div>
                  <div class="layui-form-mid layui-word-aux"></div>
                </div>

                <%--<div class="layui-form-item">
                  <label class="layui-form-label">再次确认</label>
                  <div class="layui-input-inline input-custom-width">
                    <input type="text" id="method_add" name="method_add" value="add" lay-verify="required" autocomplete="off"
                           placeholder="请输入账号密码,再次确认" class="layui-input">
                  </div>
                </div>--%>



              </div>
              <%--登陆信息  end--%>

              <%--账号设置  begin--%>
              <div id="login_info" class="layui-tab-item">
                <div class="layui-form-item">
                  <label class="layui-form-label">封面模版名称</label>
                  <div class="layui-input-inline input-custom-width">
                    <input type="text" name="name" value=""  autocomplete="off" placeholder="请输入栏目名称" class="layui-input">
                  </div>
                </div>
                <div class="layui-form-item">
                  <label class="layui-form-label">列表页模版名称</label>
                  <div class="layui-input-inline input-custom-width">
                    <input type="text" name="name" value=""  autocomplete="off" placeholder="请输入栏目名称" class="layui-input">
                  </div>
                </div>
                <div class="layui-form-item">
                  <label class="layui-form-label">详情页模版名称</label>
                  <div class="layui-input-inline input-custom-width">
                    <input type="text" name="name" value=""  autocomplete="off" placeholder="请输入栏目名称" class="layui-input">
                  </div>
                </div>
              
              </div>
               <%--账号设置  end--%>

              <div class="layui-form-item">
                <div class="layui-input-block">
                  <button class="layui-btn" lay-submit="" lay-filter="cate_add">立即提交</button>
                </div>
              </div>
            </div>
          </div>
          
        </form>
      </div>
    </div>
</div>
<script type="text/javascript">
layui.use(['element', 'form', 'upload'], function(){
  var element = layui.element()
  ,form = layui.form()
  ,jq = layui.jquery;
  //图片上传
  layui.upload({
    url: ''
    ,elem:'#image'
    ,before: function(input){
      loading = layer.load(2, {
        shade: [0.2,'#000'] //0.2透明度的白色背景
      });
    }
    ,success: function(res){
      layer.close(loading);
      jq('input[name=image_url]').val(res.path);
      layer.msg(res.msg, {icon: 1, time: 1000});
    }
  }); 
  
  //监听提交
  form.on('submit(cate_add)', function(data){
    loading = layer.load(2, {
      shade: [0.2,'#000'] //0.2透明度的白色背景
    });
    var param = data.field;
   // alert(param);
    jq.post('/userAction.do?method=add',param,function(data){
        var result = eval("("+data+")");
      if(result.code == 200){
        layer.close(loading);
        layer.msg(result.msg, {icon: 1, time: 1000}, function(){
          location.reload();//do something
        });
      }else{
        layer.close(loading);
        layer.msg(result.msg, {icon: 2, anim: 6, time: 1000});
       // layer.msg("服务器错误,请联系管理员", {icon: 2, anim: 6, time: 1000});
      }
    });
    return false;
  });
  
})
</script>
</body>
</html>

