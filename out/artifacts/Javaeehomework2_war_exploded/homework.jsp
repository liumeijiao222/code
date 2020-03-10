<%@ page import="model.Homework" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 刘美娇
  Date: 2020/3/9
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body background="image/timg.jpg">
<head>
    <title>学生作业管理系统</title>
    <%--    将指定的作业id传给/submit,以便提交作业--%>
    <script>
        function show(id) {
            let homework = document.getElementById('homeworkId')
            homework.setAttribute("value",id)
            let sub = document.getElementById('sub')
            sub.submit()
        }
    </script>
    <style type="text/css">
        body {
            background-image: url("image/timg.jpg");
        }
        table.hovertable {
            font-family: verdana,arial,sans-serif;
            font-size:11px;
            color:#333333;
            border-width: 1px;
            border-color: #999999;
            border-collapse: collapse;
            line-height:5;
            background: cadetblue;
        }
        .div1{
            margin-left:100px;
            margin-top:100px;
            background: cornflowerblue;
            width:120px;
        }
        .div2{
            margin-top: -250px;
            margin-left: 30px;
        }
    </style>
</head>
<body>

<h2 align="center" style="margin: 50px">作业管理系统</h2>
<div class="div1">
    <p>功能选择：</p>
    <ul style="line-height: 40px">
        <li><a href="addHomework.jsp">布置作业</a></li>
        <li><a href="addStudent.jsp">添加学生</a></li>
        <li><a href="/Javaeehomework2_war_exploded/homework">查看作业</a></li>
        <li><a href="/Javaeehomework2_war_exploded/showstudenthomework">提交情况</a></li>
        <li><a href="/Javaeehomework2_war_exploded/showstudent">查看学生</a></li>

    </ul>
</div>



<form id="sub" method="get" action="/Javaeehomework2_war_exploded/submit">
    <input id="homeworkId" name="id" type="hidden">
    <div class="div2" >
    <table align="center"   class="hovertable"  border="1"  width="650">
        <tr>
            <th>作业编号</th>
            <th>作业标题</th>
            <th>作业内容</th>
            <th>提交作业</th>
        </tr>

        <%
            List<Homework> list = (List<Homework>)request.getAttribute("list");
            if (list == null || list.size() <= 0){
               out.print("None data");
            }else {
                for (Homework homework : list) {
        %>
        <tr>
            <td width="10%"><%=homework.getId()%></td>
            <td width="20%" style="word-break: break-all;word-wrap: break-word"><%=homework.getTitle()%></td>
            <td width="60%" style="word-break: break-all;word-wrap: break-word"><%=homework.getContent()%></td>
            <td width="10%"><input type="button" width="70%" value="提交作业" onclick="show(<%=homework.getId()%>)" > </td>

        </tr>

        <%
                }
            }
        %>

    </table>
    </div>
</form>
</body>
</html>