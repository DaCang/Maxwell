<%--
  Created by IntelliJ IDEA.
  User: syl
  Date: 2017/9/4
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/jquery/jquery-ui.css">
<script src="/jquery/jquery.js"></script>
<script src="/jquery/jquery-ui.js"></script>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script>
        var noticeIdArr =new Array();//
        var noticeContentArr =new Array();//
        var noticeTitleArr = new Array();//
        $(function() {

            getJson()
            setTimeout("setHtml()",100)

            setTimeout("setAccordion()",100)
        });

        function getJson() {


            $.getJSON("/notice/notice.json", function (data) {
                $.each(data, function (infoIndex, info) {
                    noticeIdArr.push(info["noticeId"]);
                    noticeContentArr.push(info["noticeContent"]);
                    noticeTitleArr.push(info["noticeTitle"]);
                })
            })
          //  alert(noticeIdArr)
        }

        function setHtml() {
            var accordion = $("#accordion")
            var accordionHtml = "";//存储数据的变量
            accordion.empty();//清空内容
            for(var i=0; i<noticeIdArr.length; i++ ){
                accordionHtml += "<h3 class='ui-accordion-header'>";
                accordionHtml += noticeTitleArr[i]+"</h3>";
                accordionHtml += "<div><p>";
                accordionHtml +=noticeContentArr[i]+"</p></div>";
            }

            accordion.html(accordionHtml);//显示处理后的数据

        }
        function  setAccordion() {
            $( "#accordion" ).accordion(
                {
                    collapsible: true,//是否折叠
                    active:0,//默认打开第一个折叠面板
                    heightStyle: "content",//高度自适应
                    header: "h3"//指定标题
                }
            );
        }
    </script>
</head>
<body>
<h1>NOTICE </h1>
<div  id="accordion">

</div>


</body>
</html>