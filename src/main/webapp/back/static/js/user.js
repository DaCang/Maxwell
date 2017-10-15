var pageNum;
$(function() {

    page();
    //以下将以jquery.ajax为例，演示一个异步分页


    //getPageCount();
    layui.use(['element', 'layer','laypage', 'form'], function(){
        var element = layui.element()
            ,jq = layui.jquery
            ,form = layui.form()
            ,laypage = layui.laypage;



        /*
        * 分页
        * */
        /*laypage.render({
            cont: 100
            ,skip: true
            //,elem: 'demo7'

            ,layout: ['count', 'prev', 'page', 'next', 'limit', 'skip']
            ,groups: 5 //连续显示分页数
            ,curr: 1
            ,jump: function(e, first){ //触发分页后的回调

                loading = layer.load(2, {
                    shade: [0.2,'#000'] //0.2透明度的白色背景
                });
                $.ajax({
                    url:'/user/list.con',
                    data:{ 'pageNum':e.curr },
                    async: false,
                    type:"get",
                    dataType:"text",
                    success:function (data) {
                        if (data == null || data == "") {
                            layer.close(loading);
                            layer.msg("服务器错误,请联系管理员", {icon: 2, anim: 6, time: 1000});
                            return false;
                        }
                        var result = eval("("+data+")");
                        ///alert(data.pageCount)
                        pageNum = result.pageCount;
                        //alert(pageNum)
                        layer.close(loading);
                        setData(result.list, e.curr)

                    }

                    });
            }
            ,pages: 100 //总页数
        });*/


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


       // layer.msg('玩命加载中...',{icon: 1, time: 1000000});

        jq('.del_btn').click(function(){

            var user_name = jq(this).attr('user-name');
            var user_id = jq(this).attr('user-id');
            layer.confirm('确定删除【'+user_name+'】?', function(index){
                loading = layer.load(2, {
                    shade: [0.2,'#000'] //0.2透明度的白色背景
                });
                jq.post('/userAction.do?method=delete',{'user_id':user_id},function(data){
                    if(data==null||data=="") {
                        layer.close(loading);
                        layer.msg("服务器错误,请联系管理员", {icon: 2, anim: 6, time: 1000});
                        return false;
                    }
                    var result = eval("(" + data + ")");
                    if(result.code == 200){
                        layer.close(loading);
                        layer.msg(result.msg, {icon: 1, time: 1000}, function(){
                            location.reload();//do something
                        });
                    }else{
                        layer.close(loading);
                        layer.msg(result.msg, {icon: 2, anim: 6, time: 1000});
                    }
                });
            });

        });

    })
    //loadUserInfo();
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
function setData(data,page) {
    // alert(data);
    var userInfoHtml = "";
    var userInfo = $("#userInfo")

    //var list = eval("["+data+"]");
    var  list=data;
    for(var i=0;i<list.length;i++){
        userInfoHtml = userInfoHtml+
            "<tr>" +
            "<td>"+(i+1+(page-1)*5)+"</td>" +
            "<td>"+list[i].userId+"</td>" +
            "<td>"+list[i].userName+"</td>" +
            "<td>"+list[i].password+"</td>" +
            "<td>"+getRoleName(list[i].roleId)+"</td>" +
            "<td>"+list[i].deptId+"</td>" +
            " <td style=\"text-align: center;\">\n" +
            " <a href=\"./category_add.html\" class=\"layui-btn layui-btn-small\" title=\"编辑\"><i class=\"layui-icon\"></i></a>\n" +
            " <a  class=\"del_btn layui-btn layui-btn-small layui-btn-danger \"  onclick='del(this)' user-id=\""+list[i].userId+"\" title=\"删除\" user-name=\""+list[i].userName+"\"><i class=\"layui-icon\"></i></a>\n" +
            "  </td>" +
            "</tr>";
    }
    console.log(userInfoHtml)
    userInfo.html(userInfoHtml);//显示处理后的数据
}

function del(obj) {

    //alert(111);
    layui.use(['layer'], function () {
        var jq = layui.jquery


        var user_name = jq(obj).attr('user-name');
        var user_id = jq(obj).attr('user-id');

        layer.confirm('确定删除【' + user_name + '】?', function (index) {
            loading = layer.load(2, {
                shade: [0.2, '#000'] //0.2透明度的白色背景
            });
            jq.post('/user/del.con', {user_id: user_id}, function (data) {
                if (data == null || data == "") {
                    layer.close(loading);
                    layer.msg("服务器错误,请联系管理员", {icon: 2, anim: 6, time: 1000});
                    return false;
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
        });


        //loadUserInfo();
    })
}

function getRoleName(roleId){
    if(roleId == 'system'){
        return '系统管理员'
    }else{
        return '普通用户'
    }
}


function page(curr){
    layui.use(['element', 'layer','laypage', 'form'], function() {
        var element = layui.element()
            , jq = layui.jquery
            , form = layui.form()
            , laypage = layui.laypage;
        alert(curr || 1);
        $.ajax('/user/list.con', {
            page: curr || 1
        }, function (data) {
            //此处仅仅是为了演示变化的内容
            /*if (data == null || data == "") {
                layer.close(loading);
                layer.msg("服务器错误,请联系管理员", {icon: 2, anim: 6, time: 1000});
                return false;
            }*/
            //var result = eval("("+data+")");
            alert(data)
            //pageNum = result.pageCount;
            //alert(pageNum)
            //layer.close(loading);
            //setData(result.list, e.curr)
            //显示分页
            laypage({
                cont: 'page', //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
                pages: res.pages, //通过后台拿到的总页数
                curr: curr || 1, //当前页
                jump: function (obj, first) { //触发分页后的回调
                    if (!first) { //点击跳页触发函数自身，并传递当前页：obj.curr
                        page(obj.curr);
                    }
                }
            });
        });
    });
}