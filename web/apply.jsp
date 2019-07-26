<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content="????">
    <meta name="Description" content="?????????????" />
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="static/cont.css">
    <title>????</title>
</head>
<body>
<header class="heading">
    
    <div class="navbar">
        <ul class="uling">
               <%
        String username = (String)session.getAttribute("usernameShenQing");
        %>
              <li><a href=""><%=username%></a></li>
            <li class="fengmi"><a class="sing" href="">??????????</a></li>
            <!--<li class="logo1"><img src="../static/pic/images/bee.png" alt="" height="70px" width="70px"></li>-->
        </ul>
    </div>
</header>
<div class="con">
    <div class="middle">
        <form action="Apply" method="post">
            <p class="tishi"></p>
<p><center>typeA:<input type="text" name="typeA">
typeB:<input type="text" name="typeB">
typeC:<input type="text" name="typeC"></center>
</p>
<p>
<center>number:<input type="text" name="num">
descripe:<input type="text" name="descrip"></center>
</p>
 <center><input type="submit" value="submit"></center>
        </form>
    </div>
</div>
</body>
</html>