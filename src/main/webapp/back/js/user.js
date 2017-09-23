
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
                    " <a class=\"layui-btn layui-btn-small layui-btn-danger del_btn\" category-id=\"1\" title=\"删除\" category-name=\"学无止境\"><i class=\"layui-icon\"></i></a>\n" +
                    "  </td>" +
                    "</tr>";
            }
            userInfo.html(userInfoHtml);//显示处理后的数据
        }
    });
}