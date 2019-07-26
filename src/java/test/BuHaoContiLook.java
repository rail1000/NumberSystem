
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
public class BuHaoContiLook extends HttpServlet {
protected void doPost(HttpServletRequest request,HttpServletResponse response) 
             throws ServletException,IOException {
              response.setContentType("text/html;charset=UTF-8");
              try(PrintWriter out=response.getWriter()){
                   HttpSession session=request.getSession();
                   String username = (String)session.getAttribute("usernameBuHao");
                   //String username = "1234";
                   
                     BuHaoLookBean bean = null;
                  try{ 
                bean=(BuHaoLookBean)session.getAttribute("beanBuHaoLook");
                if(bean==null){
                  bean=new BuHaoLookBean(); 
                 
                  session.setAttribute("beanBuHaoLook",bean);
            }
      }
      catch(Exception exp){
            bean=new BuHaoLookBean();  
            session.setAttribute("beanBuHaoLook",bean);
      }
                   
                   
                      try{
            Class.forName("com.mysql.jdbc.Driver"); 
            }
            catch(Exception e){
            out.print("<br>"+e);
            }
                          try{
           //实现查询功能
           String url="jdbc:mysql://127.0.0.1/imgtest";
           String user="root";
           String key="root";
           Connection con=DriverManager.getConnection(url,user,key);
           Statement sql=con.createStatement();
           String sqlQuery = "select * from imgConti where Buser = '"+username+"'";
           ResultSet rs,rs1;
           rs = sql.executeQuery(sqlQuery);
           
           int num;//查询到的记录数
           rs.last();
           num=rs.getRow();
           int[] id = new int[num];
           //String[] type = new String[num];
           //String[] typeA = new String[num];
           //String[] typeB = new String[num];
           //String[] typeC = new String[num];
           //String[] Bnumber = new String[num];
           //String[] descrip = new String[num];
           int[] agreeFlag = new int[num];
           int[] chec = new int[num];
           int[] Bid = new int[num];
           int i=0;
           //为防止错误，重新生成一个结果集
            rs1 = sql.executeQuery(sqlQuery);
            while(rs1.next()){
             
             id[i]=rs1.getInt(1);
             chec[i]=rs1.getInt(3);
             agreeFlag[i]=rs1.getInt(4);
             Bid[i]=rs1.getInt(5);
             //Bnumber[i]=rs1.getString(5);
             //descrip[i]=rs1.getString(6);
            //agreeFlag[i]=rs1.getInt(7);
            //chec[i]=rs1.getInt(8);
            //rs1.getDate(10);
             i++;
            }
            //将数据放入bean中
            bean.setId(id);
            bean.setChec(chec);
            bean.setAgreeFlag(agreeFlag);
            bean.setBid(Bid);
            bean.setNum(num);
            //bean.setTypeA(typeA);
            //bean.setTypeB(typeB);
            //bean.setTypeC(typeC);
            //bean.setAgreeFlag(agreeFlag);
            //bean.setChec(chec);
            //重定向
            response.sendRedirect("BuHaoContiLook.jsp");
           
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
