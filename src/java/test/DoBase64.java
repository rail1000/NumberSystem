
package test;



import java.io.FileWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import sun.misc.BASE64Encoder;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;



public class DoBase64 extends HttpServlet {
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
               String url="jdbc:mysql://127.0.0.1/imgtest";
               String url1="jdbc:mysql://127.0.0.1/picknumber";
               String user="root";
               String key="root";
               Connection con=DriverManager.getConnection(url,user,key);
               Connection con1=DriverManager.getConnection(url1,user,key);
               String sqlQuery = "select path from img where chec='0'";
               Statement sql=con.createStatement();
                Statement sql1=con1.createStatement();
              ResultSet rs,rs1,rs2,rs3;
              rs = sql.executeQuery(sqlQuery);
              rs.last();
              int num=rs.getRow();
              rs.first();
              String[] imgUri = new String[num];
              String[] imgBase64 = new String[num];
              int i=0;
              
              String sqlQuery1 = "select path from img where chec='0'";
              rs1 = sql.executeQuery(sqlQuery1);
              out.print(num+"<br>");
              while(rs1.next()){
                  imgUri[i] = rs1.getString(1);
                  i++;
              }
                
              String[] strArray = null;
              String[] number = null;
            for(int j = 0;j<imgUri.length;j++){
                
                String host = "https://ocrapi-document.taobao.com";
                String path = "/ocrservice/document";
                String method = "POST";
                String appcode = "09438cf0aa564a27b91e84609f486328";
                Map<String, String> headers = new HashMap<String, String>();
                headers.put("Authorization", "APPCODE " + appcode);
                headers.put("Content-Type", "application/json; charset=UTF-8");
                Map<String, String> querys = new HashMap<String, String>();
                String bodys = null;

                try {
                    bodys = "{\"img\":\""+ changeToBase64(imgUri[j])+"\",\"prob\":false}";
                } 
                catch (Exception e) {
                    out.print(e);
                }
                try {
                    HttpResponse responses = HttpUtils.doPost(host, path, method, headers, querys, bodys);
                    strArray = prase(EntityUtils.toString(responses.getEntity()));   
                    System.out.println("strArray:"+strArray[0]);
                    
                    String Bid = request.getParameter("Bid");
                     System.out.print("Bid:");
                     System.out.println(Bid);
                     
                    String sqlQuery2 = "select typeA,typeB,typeC,Bnumber from apply where id ="+Bid;
                    
                    rs2 = sql1.executeQuery(sqlQuery2);
                   
                    String sqlQuery3 = "select a.typeA,a.typeB,a.typeC,a.Bnumber from img,picknumber.apply as a where img.Bid = a.id and img.chec = 0 and img.Bid = "+Bid;
                    rs3 = sql.executeQuery(sqlQuery3);
                  
                    rs3.last();
                    int num1=rs3.getRow();
                      
                    number = new String[num1];
                    int t=0;
                    System.out.println("sqlQuery2:"+sqlQuery2);
                    try{
                        rs2.next();
                        number[t] = rs2.getString(1)+rs2.getString(2)+rs2.getString(3)+rs2.getString(4);
                     System.out.println("number2222:"+number[t]);}
                    catch(SQLException e){
                          System.out.println("SQLException:"+e);
                    }
                    /*
                    while(rs2.next()){
                         number[t] = rs2.getString(1)+rs2.getString(2)+rs2.getString(3)+rs2.getString(4);
                          
                          System.out.println(rs2.getString(1));
                         t++;
                    }
                    */
                    //System.out.println(strArray[0]);
                    for(int k=0;k<strArray.length;k++){
                        if(strArray[k].equals(number[k])){
                               String sqlUpdate = "update img set chec=1,agree=1 where Bid ="+Bid;
                               sql.executeUpdate(sqlUpdate);
                               String sqlUpdate1 = "update apply set chec=2,agree=2 where id ="+Bid;
                               sql1.executeUpdate(sqlUpdate1);
                               //request.setAttribute("message","校验成功");
                               String message = "sucess";
                                //重定向
                                 response.sendRedirect("httpTest.jsp?message="+message);
                            }
                        else{
                                String sqlUpdate1 = "update img set chec=1,agree=0 where Bid ="+Bid;
                                sql.executeUpdate(sqlUpdate1);
                                String sqlUpdate2 = "update apply set chec=1,agree=1 where id ="+Bid;
                               sql1.executeUpdate(sqlUpdate2);
                                String message = "fail";
                                //重定向
                                 response.sendRedirect("httpTest.jsp?message="+message);
                        }
                    }
                    
                } 
                catch (Exception e) {
                   out.print(e);
                }
               
          }
          
          
        }
        catch(Exception ex){
            PrintWriter out = response.getWriter();
                out.print(ex);
        }
        
    }
    
    
    
     public String[] prase(String string){
        JSONObject jsonObject=JSONObject.parseObject(string);
        JSONArray jsonArray=jsonObject.getJSONArray("prism_wordsInfo");
        String[] strArray= new String[jsonArray.size()];
        for (int i=0;i<jsonArray.size();i++){
            JSONObject newjsonObject=(JSONObject) jsonArray.get(i);
            strArray[i] = newjsonObject.getString("word");
            
        }
        
        return strArray;
        
    }
     

    
    public static String changeToBase64(String fileName) throws Exception{
        File file = new File(fileName);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int)file.length()];
        inputFile.read(buffer);
        inputFile.close();
        String base64Code=new BASE64Encoder().encode(buffer);
        return base64Code;
    }
    
     protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        try(PrintWriter out = response.getWriter();){
            doPost(request,response);
        }
     
     }
}
