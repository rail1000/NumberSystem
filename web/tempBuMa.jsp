

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8"> 
    <link rel="stylesheet" href="static/gif.css">
    <title>补号系统</title>
</head>
<body>
<header class="heading">
    <%
        String username = request.getParameter("username");
        //HttpSession session=request.getSession();
        session.setAttribute("usernameBuHao", username);
        %>
    <div class="navbar">
        <ul class="uling">          
              <li><a href=""><%=username%></a></li>           
            <h1 class="buhao">补号系统</h1>
        </ul>
    </div>
</header>
<div class="meng">
<div class="con">
    <div class="box1">
         
       
        <div class="item1"><a href="httpTest.jsp" class="zi1">非连续号码上传补码图片</a></div>
         <div class="item4">    <a href="BuHaoLook" class="zi1">非连续号码补号单查看</a></div>
        
        <div class="item3"> <a href="httpTestConti.jsp" class="zi1">连续号码上传补码图片</a></div>
       <div class="item2">  <a href="BuHaoContiLook" class="zi1">连续号码补号单查看</a></div>
       <div class="item5">  <a href="ApplyLookAll" class="zi1">非连续号码申请单查看</a></div>
       <div class="item1">  <a href="ApplyContiLookAll" class="zi1">连续号码申请单查看</a></div>
        
        
    </div>
</div>
</div>
</body>
</html>



 
       
     
       
