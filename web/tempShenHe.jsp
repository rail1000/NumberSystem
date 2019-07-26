<%-- 
    Document   : tempShenHe
    Created on : 2019-7-20, 23:01:21
    Author     : Windows10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <%
        String username = request.getParameter("username");
        //HttpSession session=request.getSession();
        session.setAttribute("usernameShenHe", username);
        %>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content="补号审核系统">
    <meta name="Description" content="巴拉巴拉巴拉巴拉巴拉巴拉吧" />
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="static/gif.css">
    <title>补号审核系统</title>
</head>
<body>
<header class="heading">
    <div class="navbar">
        <ul class="uling">
            
            <li><a href=""><%=username%></a></li>
           
            <li class="fengmi"><a class="sing" href="tempShenHe.jsp">补号审核系统</a></li>
        </ul>
    </div>
</header>
<div class="meng">
<div class="con">
    <div class="box1">
        <div class="item1"><a href="AuditConti" class="zi1">审核连续补号</a></div>
        <div class="item2"><a href="Audit" class="zi1">审核非连续补号</a></div>
    </div>

</div>

</div>
</body>
</html>
      
