<%-- 
    Document   : BuHaoLook
    Created on : 2019-7-24, 21:40:54
    Author     : Windows10
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        
    <meta charset="UTF-8">
    <link rel="stylesheet" href="static/search_result.css">
    <title>补号--查看补号单</title>

        <jsp:useBean id="beanBuHaoLook" class="test.BuHaoLookBean" scope="session" />
    </head>
    <body>
        
         <header class="heading">
    <div class="navbar">
        <ul class="uling">
               <%
        String username = (String)session.getAttribute("usernameBuHao");
        %>
              <li><a href=""><%=username%></a></li>
            <h2 class="check">查看连续补号单</h2>
        </ul>
    </div>
</header>
        
             
<div class="con">
    <div class="box">
<table border="1" align="center">
    <caption>连续补号单</caption>
            <tr>
                <th>补号单id</th>
                <th>补号码</th>
                <th>当前补号单状态</th>
                <th>当前校验状态</th>
            </tr>
        
         <%
        int num=beanBuHaoLook.getNum();
        int[] id = new int[num];
        int[] agreeFlag = new int[num];
        int[] chec = new int[num];
        int[] Bid = new int[num];
        id = beanBuHaoLook.getId();
        Bid = beanBuHaoLook.getBid();
        agreeFlag = beanBuHaoLook.getAgreeFlag();
        chec = beanBuHaoLook.getChec();
        %>
        <%
            String status = "";
            String flag = "";
        for(int i=0;i<num;i++){
        int idItem = id[i];
        int bidItem = Bid[i];
        int agreeFlagItem = agreeFlag[i];
        int checItem = chec[i];
        %>
        <%
            if(checItem == 0){
                flag = "未校验";
                
            }else if(checItem == 1){
            flag = "已校验";
            }else{
        flag = "补号校验成功";
        }
            
            
            if(agreeFlagItem == 0){
                status = "失败";
            }
            else if(agreeFlagItem == 1){
                status = "成功";
            }
            else{
            status = "已同意";
            }
            
            %>
            
             <tr>
                <td><%=idItem%></td>
                <td><%=bidItem%></td>
                <td><%=status%></td>
                <td><%=flag%></td>
             </tr>
             <%--
            <li>补号单id:&nbsp;<%=idItem%> &nbsp; &nbsp; &nbsp; &nbsp;补号码:<%=bidItem%> &nbsp; &nbsp; &nbsp; &nbsp;
           
            当前补号单状态:&nbsp;<%=status%>
              当前校验状态：&nbsp;<%=flag%> &nbsp; &nbsp; &nbsp; &nbsp;
            </li>
             --%>
        <%
        }

        %>
        
                      
</table>
        </div>  
    </div>
    </body>
</html>
