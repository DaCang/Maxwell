
$(function() {


    loadUserInfo();
});
/*
*
*[
    {
        "deptId":"",
        "passWord":"123",
        "roleId":"system",
        "status":"0",
        "userId":"admin",
        "userName":"系统管理员"
    },
    {
        "deptId":"001",
        "passWord":"syl",
        "roleId":"001",
        "status":"0",
        "userId":"syl",
        "userName":"宋永利"
    }
]*/
/*
* 获取用户信息
* */
function loadUserInfo () {
    var userInfoHtml = "";
    var userInfo = $("#userInfo")

    var ls_url="/userAction.do?user_id="+user_id+"&role_id="+role_id;
    //alert(ls_url);
    $.ajax({
        url:ls_url,
        async: false,
        type:"get",
        dataType:"text",
        success:function (data) {
            // alert(data);
            var list = eval("("+data+")");
            for(var i=0;i<list.length;i++){
                userInfoHtml = userInfoHtml+
                    "<tr>" +
                    "<td>"+i+"</td>" +
                    "<td>"+list[i].userId+"</td>" +
                    "<td>"+list[i].userName+"</td>" +
                    "<td>"+list[i].passWord+"</td>" +
                    "<td>"+list[i].roleId+"</td>" +
                    "<td>"+list[i].deptId+"</td>" +
                    " <td style=\"text-align: center;\">\n" +
                    " <a href=\"./category_add.html\" class=\"layui-btn layui-btn-small\" title=\"编辑\"><i class=\"layui-icon\"></i></a>\n" +
                    " <a class=\"layui-btn layui-btn-small layui-btn-danger del_btn\"  user-id=\""+list[i].userId+"\" title=\"删除\" user-name=\""+list[i].userName+"\"><i class=\"layui-icon\"></i></a>\n" +
                    "  </td>" +
                    "</tr>";
            }
            userInfo.html(userInfoHtml);//显示处理后的数据
        }
    });
}
function deleteUser(user_id) {
    layui.use(['element', 'form', 'upload'], function() {
        var element = layui.element()
            , form = layui.form()
            , jq = layui.jquery;
        //监听提交
        // form.on('submit(cate_add)', function(data){
        /*loading = layer.load(2, {
            shade: [0.2, '#000'] //0.2透明度的白色背景
        });*/
        var param = user_id;
        // alert(param);
        jq.post('/userAction.do?method=delete', param, function (data) {
            if(data==null||data==""){
               // layer.msg("服务器错误,请联系管理员", {icon: 2, anim: 6, time: 1000});
                return;
            }
            var result = eval("(" + data + ")");
            if (result.code == 200) {
                layer.close(loading);
                layer.msg(result.msg, {icon: 1, time: 1000}, function () {
                    location.reload();//do something
                });
            } else {
                layer.close(loading);
                layer.msg(result.msg, {icon: 2, anim: 6, time: 1000});

            }
        });
        return false;
    })

}