
package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class doAudit extends HttpServlet {

     protected void doPost(HttpServletRequest request,HttpServletResponse response) 
             throws ServletException,IOException {
              response.setContentType("text/html;charset=UTF-8");
              try(PrintWriter out=response.getWriter()){
                 
                  
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
           
           ResultSet rs,rs1;
           
           //从request中获取数据
           Enumeration pNames=request.getParameterNames();
                  
                  while(pNames.hasMoreElements()){
                        String id=(String)pNames.nextElement();
                        String agreeFlag=request.getParameter(id);
                        String sqlUpdate = "update apply set agree = "+agreeFlag+" where id = "+id;
                        sql.executeUpdate(sqlUpdate);
                        //out.print(name + "=" + value);
                }
                    response.sendRedirect("Audit");
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
