
<%@page import="test.AuditBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="beanConti" class="test.AuditContiBean" scope="session" />
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content="申请补号">
    <meta name="Description" content="巴拉巴拉巴拉巴拉巴拉巴拉吧" />
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="static/cont.css">
    <title>补号审核</title>
</head>
<body>
<header class="heading">
    <div class="navbar">
        <ul class="uling">
           <%
        String username = (String)session.getAttribute("usernameShenHe");
        %>
              <li><a href=""><%=username%></a></li>
            <li class="fengmi"><a class="sing" href="">补号审核</a></li>
            <!--<li class="logo1"><img src="../static/pic/images/bee.png" alt="" height="70px" width="70px"></li>-->
        </ul>
    </div>
</header>
<div class="con">
    <div class="middle">
        <form action="doAuditConti" method="post">
            <style type="text/css">
table
{
border-collapse :collapse ;
}
th,td
{

border :2px solid black;

}     
</style>
<center> <p class="tishi">补号审核表</p></center>
<center><table border="1">

  <tr>
    <th>补号单id</th>
    <th>起始号码</th>
    <th>结尾号码</th>
    <th>描述</th>
    <th>类型A</th>
    <th>类型B</th>
    <th>类型C</th>
    <th>当前状态</th>
  </tr>
       


        <%-- 从session中取出bean--%>
        
        
        
        <%
        int num=beanConti.getNum();
        int[] id = new int[num];
           String[] type = new String[num];
           String[] numBegin = new String[num];
           String[] numEnd = new String[num];
           String[] descrip = new String[num];
             String[] typeA = new String[num];
           String[] typeB = new String[num];
           String[] typeC = new String[num];
        int[] agreeFlag = new int[num];
        id = beanConti.getId();
        numBegin = beanConti.getNumBegin();
        numEnd = beanConti.getNumEnd();
        type = beanConti.getType();
        descrip = beanConti.getDescrip();
        agreeFlag = beanConti.getAgreeFlag();
         typeA = beanConti.getTypeA();
        typeB = beanConti.getTypeB();
        typeC = beanConti.getTypeC();
        %>
        <ul>

        <%
            String status = "";
        for(int i=0;i<num;i++){
        int idItem = id[i];
        String beginItem = numBegin[i];
        String endItem = numEnd[i];
        String descripItem = descrip[i];
        String typeItem = type[i];
        int agreeFlagItem = agreeFlag[i];
        String typeAItem = typeA[i];
        String typeBItem = typeB[i];
        String typeCItem = typeC[i];
        %>
        <%
            if(agreeFlagItem == 0){
                status = "未审核";
            }
            else if(agreeFlagItem == 1){
                status = "不同意";
            }
            else{
            status = "已同意";
            }
            
            %>
             <tr>
    <td><%=idItem%></td>
    <td><%=beginItem%></td>
    <td><%=endItem%></td>
    <td><%=descripItem%></td>
    <td><%=typeAItem%></td>
    <td><%=typeBItem%></td>
    <td><%=typeCItem%></td>
          
            <%
            if(agreeFlagItem == 0){
            %>
             <td>
          <select name="<%=id[i]%>">
            
<option value="0" selected>未审核</option>
<option value="1">不同意</option>
<option value="2">同意</option>
</select>
          </td>
            <%
            }
            else if(agreeFlagItem == 1){
                %>
            <td>
            <select name="<%=id[i]%>">
            
<option value="0">未审核</option>
<option value="1">不同意</option>
<option value="2" selected>同意</option>
</select>
             </td>

            <%
            }
            else{
            %>
             <td>
            <select name="<%=id[i]%>">
            
<option value="0">未审核</option>
<option value="1">不同意</option>
<option value="2" selected>同意</option>
</select>
             </td>

            <%
            }
            %>
</tr>
        <%
        }

        %>
        
        
        </ul>
        <br>
      
     </table></center>
 <center><input type="submit" value="提交"></center>
        </form>
    </div>
</div>
</body>
</html>
