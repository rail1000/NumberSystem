

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="static/publish.css">
    <title>补号--连续号段上传图片</title>
</head>
<body>
<header class="heading">
    <div class="navbar">
        <ul class="uling">
           <%
        String username = (String)session.getAttribute("usernameBuHao");
        %>
              <li><a href=""><%=username%></a></li>
            <h2 class="pic2">连续号段上传图片</h2>
        </ul>
    </div>
</header>


<div class="con">
 <form action="ImgSave" method="post" enctype="multipart/form-data" name="upload_form">
    <div class="box">
        <div class="box1">

            <div class="item1">

                <img src="static/pic/upl.png" alt="" height="300px" width="300px" class="uploading" >
                   
                <a href="javascript:;" class="file">请选择图片
                   <input  name="uploadFile1" type="file" accept="image/x-png,image/gif,image/jpeg,image/bmp">
                </a>
            </div>

        </div>



        <div class="box2">
            <div class="item2">
                <div class="kuanga">
                       <p><a class="titb">填写编号：</a><input name="Bid" type="text"></p> 
                   <p>  <a class="btnb">提交：</a>  <input name="upload" type="submit" value="submit" /></p>
                      
                    
</div>

            </div>

        </div>
        
    </div>
          </form>
</div>
</body>
 <%
        String message = request.getParameter("message");
        if(message!=null){
        if(message.equals("sucess")){
        %>
          <script>
           
            window.alert("<%="校验成功"%>");
              </script> 
        
            <%        }else if(message.equals("fail")){
%>
             <script>
           
            window.alert("<%="校验失败"%>");
              </script> 
              <%

}
}
  %>
</html>


<%--

                    <form action="ImgSave" method="post" enctype="multipart/form-data" name="upload_form">

  <label>选择图片文件</label>

 <input name="uploadFile1" type="file" accept="image/gif, image/jpeg"/>
 Bid:<input name="Bid" type="text">
 <br>
  <input name="upload" type="submit" value="submit" />
<img src="../static/pic/upl.png" alt="" height="300px" width="300px" class="uploading" >
                   
        <%
        String message = request.getParameter("message");
        if(message!=null){
        if(message.equals("sucess")){
        %>
          <script>
           
            window.alert("<%="校验成功"%>");
              </script> 
        
            <%        }else if(message.equals("fail")){
%>
             <script>
           
            window.alert("<%="校验失败"%>");
              </script> 
              <%

}
}
  %>

--%>



 
      
