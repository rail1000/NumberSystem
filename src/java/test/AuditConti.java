/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Windows10
 */
public class AuditConti extends HttpServlet {

   protected void doPost(HttpServletRequest request,HttpServletResponse response) 
             throws ServletException,IOException {
              response.setContentType("text/html;charset=UTF-8");
              try(PrintWriter out=response.getWriter()){
                  //使用session，主要是将bean放进session中，方便前端使用
                 HttpSession session=request.getSession();
                 String username = (String)session.getAttribute("usernameAudit");
                 //声明一个AuditBean，并实例化
                 AuditContiBean bean = null;
                  try{ 
                bean=(AuditContiBean)session.getAttribute("beanConti");
                if(bean==null){
                  bean=new AuditContiBean(); 
                 
                  session.setAttribute("beanConti",bean);
            }
      }
      catch(Exception exp){
            bean=new AuditContiBean();  
            session.setAttribute("beanConti",bean);
      }
              //连接数据库
               try{
            Class.forName("com.mysql.jdbc.Driver"); 
            }
            catch(Exception e){
            out.print("<br>"+e);
            }
               try{
           //实现查询功能
           String url="jdbc:mysql://127.0.0.1/picknumber";
           String user="root";
           String key="root";
           Connection con=DriverManager.getConnection(url,user,key);
           Statement sql=con.createStatement();
           String sqlQuery = "select * from applyConti where agree = 0";
           ResultSet rs,rs1;
           rs = sql.executeQuery(sqlQuery);
           
           int num;//查询到的记录数
           rs.last();
           num=rs.getRow();
           int[] id = new int[num];
           String[] type = new String[num];
            String[] typeA = new String[num];
           String[] typeB = new String[num];
           String[] typeC = new String[num];
           String[] numBegin = new String[num];
           String[] numEnd = new String[num];
           String[] descrip = new String[num];
           int[] agreeFlag = new int[num];
           int i=0;
           //为防止错误，重新生成一个结果集
            rs1 = sql.executeQuery(sqlQuery);
            while(rs1.next()){
             
             id[i]=rs1.getInt(1);
             typeA[i]=rs1.getString(2);
             typeB[i]=rs1.getString(3);
             typeC[i]=rs1.getString(4);
             numBegin[i]=rs1.getString(5);
             numEnd[i]=rs1.getString(6);
             descrip[i]=rs1.getString(7);
            agreeFlag[i]=rs1.getInt(8);
             i++;
            }
            //将数据放入bean中
            bean.setId(id);
            bean.setNumBegin(numBegin);
            bean.setNumEnd(numEnd);
            bean.setDescrip(descrip);
            bean.setType(type);
            bean.setAgreeFlag(agreeFlag);
            bean.setNum(num);
            bean.setTypeA(typeA);
            bean.setTypeB(typeB);
            bean.setTypeC(typeC);
            //重定向
            response.sendRedirect("auditConti.jsp");
            
            
               }
               catch(Exception e){
               out.print(e);
               }     
                  
                  
                  
                  
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
doPost(request,response);

}
}
