<%@page import="java.util.Date"%>
<jsp:useBean id="beanLookConti" class="test.ApplyContiLookBean" scope="session" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content="申请补号">
    <meta name="Description" content="巴拉巴拉巴拉巴拉巴拉巴拉吧" />
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="static/cont.css">
    <title>申请补号</title>
</head>
<body>
<header class="heading">
    <div class="navbar">
        <ul class="uling">
             <%
        String username = (String)session.getAttribute("usernameShenQing");
        %>
              <li><a href=""><%=username%></a></li>
            <li class="fengmi"><a class="sing" href="">申请补号</a></li>
            <!--<li class="logo1"><img src="../static/pic/images/bee.png" alt="" height="70px" width="70px"></li>-->
        </ul>
    </div>
</header>
<div class="con">
    <div class="middle">
        
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
<center> <p class="tishi">补号申请表</p></center>
<center><table border="1">
  <tr>
    <th>编号</th>
    <th>类型A</th>
    <th>类型B</th>
    <th>类型C</th>
    <th>开始号码</th>
    <th>结尾号码</th>
    <th>描述</th>
    <th>审核状态</th>
    <th>校验状态</th>
    <th>申请日期</th>
  </tr>
           <%
        int num=beanLookConti.getNum();
         String[] numBegin = new String[num];
           String[] numEnd = new String[num];
        int[] id = new int[num];
          // String[] type = new String[num];
             String[] typeA = new String[num];
           String[] typeB = new String[num];
           String[] typeC = new String[num];
           //String[] Bnumber = new String[num];
           String[] descrip = new String[num];
           Date[] date = new Date[num];
        int[] agreeFlag = new int[num];
        int[] chec = new int[num];
        id = beanLookConti.getId();
        numBegin =beanLookConti.getNumBegin();
        numEnd = beanLookConti.getNumEnd();
        //type = beanContiLook.getType();
        descrip = beanLookConti.getDescrip();
        agreeFlag = beanLookConti.getAgreeFlag();
        typeA = beanLookConti.getTypeA();
        typeB = beanLookConti.getTypeB();
        typeC = beanLookConti.getTypeC();
        chec = beanLookConti.getChec();
        date = beanLookConti.getDate();
        %>
        <%
            String status = "";
            String flag = "";
        for(int i=0;i<num;i++){
        int idItem = id[i];
        String beginItem = numBegin[i];
        String endItem = numEnd[i];
        String descripItem = descrip[i];
        //String typeItem = type[i];
        String typeAItem = typeA[i];
        String typeBItem = typeB[i];
        String typeCItem = typeC[i];
        Date dateItem = date[i];
        int agreeFlagItem = agreeFlag[i];
        int checItem = chec[i];
        %>
        <%
            if(checItem == 0){
                flag = "未校验";
                
            }else if(checItem == 1){
            flag = "补号校验失败";
            }else{
        flag = "补号校验成功";
        }
            
            
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
    <td><%=typeAItem%></td>
    <td><%=typeBItem%></td>
    <td><%=typeCItem%></td>
    <td><%=beginItem%></td>
    <td><%=endItem%></td>
    <td><%=descripItem%></td>
    <td><%=status%></td>
    <td><%=flag%></td>
    <td><%=dateItem%></td>
  </tr>
           
        <%
        }

        %>
    </table></center>
        
    </div>
</div>
</body>
</html>
