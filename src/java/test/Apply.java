
package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Apply extends HttpServlet {
protected void doPost(HttpServletRequest request,HttpServletResponse response) 
             throws ServletException,IOException {
              response.setContentType("text/html;charset=UTF-8");
              try(PrintWriter out=response.getWriter()){
                   HttpSession session=request.getSession();
                   String username = (String)session.getAttribute("usernameApply");
                  String typeA = request.getParameter("typeA");
                  if(typeA!=null){
                  String typeB = request.getParameter("typeB");
                  String typeC = request.getParameter("typeC");
                  String Bnumber = request.getParameter("num");
                   String descrip = new String(request.getParameter("descrip").getBytes("ISO-8859-1"),"utf-8");
                  //String username = "1234"; 
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
           String sqlQuery = "insert into apply(typeA,typeB,typeC,Bnumber,descrip,username)values('"+typeA+"','"+typeB+"','"+typeC+"','"+Bnumber+"','"+descrip+"','"+username+"')";
            sql.executeUpdate(sqlQuery);
            //重定向
            response.sendRedirect("apply.jsp");
            
            
               }
               catch(Exception e){
               out.print(e);
               }     
                  
                }
                   else{
            response.sendRedirect("apply.jsp");
             }
               
      }catch(Exception e){
          PrintWriter out=response.getWriter();
          out.print(e);
               
      }     
                
                  
                  
                  
        }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
doPost(request,response);

}
}
