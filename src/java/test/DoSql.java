
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


public class DoSql extends HttpServlet {


        protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        try(PrintWriter out = response.getWriter();){
        //连接数据库
         try{
            Class.forName("com.mysql.jdbc.Driver"); 
            }
            catch(Exception e){
            out.print("<br>"+e);
            }
           String url="jdbc:mysql://127.0.0.1/Number";
           String user="root";
           String key="root";
           Connection con=DriverManager.getConnection(url,user,key);
           String sqlSelect = "select path from img where check = 0";
           Statement sql=con.createStatement();
           ResultSet rs;
           rs = sql.executeQuery(sqlSelect);
           
           
           
           
 }catch(Exception ex){
            PrintWriter out = response.getWriter();
                out.print(ex);
        }
    }
    

}
