<%-- 
    Document   : tempShenQing
    Created on : 2019-7-22, 16:30:29
    Author     : Windows10
--%>
<html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content="补号申请系统">
    <meta name="Description" content="巴拉巴拉巴拉巴拉巴拉巴拉吧" />
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="static/gif.css">
    <title>补号申请系统</title>
    <%
        String username = request.getParameter("username");
        //HttpSession session=request.getSession();
        session.setAttribute("usernameShenQing", username);
        %>
</head>
<body>
<header class="heading">
    <div class="navbar">
        <ul class="uling">
          
             <li><a href=""><%=username%></a></li>
           
            <li class="fengmi"><a class="sing" href="tempShenQing.jsp">补号申请系统</a></li>
        </ul>
    </div>
</header>
<div class="meng">
<div class="con">
    <div class="box1">
        <div class="item1"><a href="Apply" class="zi1">非连续码申请补号</a></div>
        <div class="item2"><a href="ApplyConti" class="zi1">连续码申请补号</a></div>
        <div class="item3"><a href="ApplyLook" class="zi1">查看非连续码申请单</a></div>
        <div class="item4"><a href="ApplyContiLook" class="zi1">查看连续码申请单</a></div>
    </div>

</div>

</div>
</body>
</html>
        
        
