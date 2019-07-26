
package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ApplyLook extends HttpServlet {

  
    protected void doPost(HttpServletRequest request,HttpServletResponse response) 
             throws ServletException,IOException {
              response.setContentType("text/html;charset=UTF-8");
              try(PrintWriter out=response.getWriter()){
                   HttpSession session=request.getSession();
                   
                   //String username = "1234";
                   String username = (String)session.getAttribute("usernameApply");
                   
                     ApplyLookBean bean = null;
                  try{ 
                bean=(ApplyLookBean)session.getAttribute("beanLook");
                if(bean==null){
                  bean=new ApplyLookBean(); 
                 
                  session.setAttribute("beanLook",bean);
            }
      }
      catch(Exception exp){
            bean=new ApplyLookBean();  
            session.setAttribute("beanLook",bean);
      }
                   
                   
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
           String sqlQuery = "select * from apply where username='"+username+"'";
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
           String[] Bnumber = new String[num];
           String[] descrip = new String[num];
           Date[] date = new Date[num];
           int[] agreeFlag = new int[num];
           int[] chec = new int[num];
           
           int i=0;
           //为防止错误，重新生成一个结果集
            rs1 = sql.executeQuery(sqlQuery);
            while(rs1.next()){
             
             id[i]=rs1.getInt(1);
             typeA[i]=rs1.getString(2);
             typeB[i]=rs1.getString(3);
             typeC[i]=rs1.getString(4);
             Bnumber[i]=rs1.getString(5);
             descrip[i]=rs1.getString(6);
            agreeFlag[i]=rs1.getInt(7);
            chec[i]=rs1.getInt(8);
            
            date[i]=rs1.getDate(10);
             i++;
            }
            //将数据放入bean中
            bean.setId(id);
            bean.setBnumber(Bnumber);
            bean.setDescrip(descrip);
            bean.setType(type);
            bean.setTypeA(typeA);
            bean.setTypeB(typeB);
            bean.setTypeC(typeC);
            bean.setAgreeFlag(agreeFlag);
            bean.setNum(num);
            bean.setChec(chec);
            bean.setDate(date);
            //重定向
            response.sendRedirect("applyLook.jsp");
           
              }
               catch(Exception e){
               out.print(e);
               }
                  

     }
               catch(Exception e){
                  // PrintWriter out=response.getWriter();
               System.out.print(e);
               }     
                  
                  
                  
                  
        }
   
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
doPost(request,response);

}
    
}

   