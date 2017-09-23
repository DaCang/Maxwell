
$(function() {


    getDeptJson();

    getRoleJson();
});
function getDeptJson() {
    // language=JQuery-CSS
    var dept_select = $("#dept_id");
    var deptSelectHtml = "";//存储数据的变量
    dept_select.empty();//清空内容
    deptSelectHtml += "<option value=''>请选择</option>";

    $.getJSON("/back/json/deptBaseCode.json", function (data) {

        $.each(data, function (infoIndex, info) {

            deptSelectHtml += "<option value='"+info["deptId"]+"'>"+info["deptName"]+"</option>";

        })
        dept_select.html(deptSelectHtml);//显示处理后的数据
    });

}
function getRoleJson() {
    var role_select = $("#role_id")
    var roleSelectHtml = "";//存储数据的变量
    role_select.empty();//清空内容
    roleSelectHtml += "<option value=''>请选择</option>";

    $.getJSON("/back/json/roleBaseCode.json", function (data) {

        $.each(data, function (infoIndex, info) {

            roleSelectHtml += "<option value='"+info["roleId"]+"'>"+info["roleName"]+"</option>";

        })
        role_select.html(roleSelectHtml);//显示处理后的数据
    });

}