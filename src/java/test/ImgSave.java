
package test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class ImgSave extends HttpServlet {
     
    String Bid;
    private static final long serialVersionUID = 1L;
     
    // 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "upload";
 
    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
    

    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        try(PrintWriter out = response.getWriter();){
             HttpSession session=request.getSession();
                   String username = (String)session.getAttribute("usernameApply");
        //连接数据库
         try{
            Class.forName("com.mysql.jdbc.Driver"); 
            }
            catch(Exception e){
            out.print("<br>"+e);
            }
           String url="jdbc:mysql://127.0.0.1/imgtest";
           String user="root";
           String key="root";
           Connection con=DriverManager.getConnection(url,user,key);
           String sqlSelect = "select path from img where check = 0";
           Statement sql=con.createStatement();
          ResultSet rs;
           //rs = sql.executeQuery(sqlSelect);
        
        // 检测是否为多媒体上传
        if (!ServletFileUpload.isMultipartContent(request)) {
            // 如果不是则停止
            PrintWriter writer = response.getWriter();
            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            return;
        }
 
        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
 
        ServletFileUpload upload = new ServletFileUpload(factory);
         
        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);
         
        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);
        
        // 中文处理
        upload.setHeaderEncoding("UTF-8"); 

        // 构造临时路径来存储上传的文件
        // 这个路径相对当前应用的目录
        String uploadPath = getServletContext().getRealPath("/") + File.separator + UPLOAD_DIRECTORY;
       
         
        // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
 
        try {
            // 解析请求的内容提取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
            String filePath="";
            String id = "";
            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                       filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        
                        // 保存文件到硬盘
                        item.write(storeFile);
                        request.setAttribute("message",
                            filePath);
                        String temp1 = filePath.replace("\\\\", "\\");
                        String temp=temp1.replace("\\","\\\\");
                        // 在控制台输出文件的上传路径
                        //System.out.println(temp);
                        String strInsert = "insert into img(path,Buser) VALUES ('"+temp+"','"+username+"')";
                        sql.executeUpdate(strInsert);
                        String strQuery = "select id from img where path = '"+temp+"'";
                        rs = sql.executeQuery(strQuery);
                        while(rs.next()){
                        id = rs.getString(1);
                        }
                        request.setAttribute("message",
                            temp);
                        //sql.close();
                        //con.close();
                    }
                    else{
                        String name = item.getFieldName();
                        String value = item.getString();
                        if(!value.equals("submit")){
                        Bid = value;}
                        String strUpBid = "update img set Bid = '"+value+"' where id = '"+id+"'";
                        sql.executeUpdate(strUpBid);
                        
                }
                }
            }
             //RequestDispatcher dispatcher = request.getRequestDispatcher("DoBase64");
        //dispatcher.forward(request, response);
            //request.setAttribute("message",
            //                temp);
        } catch (Exception ex) {
            request.setAttribute("message",
                    "错误信息: " + ex.getMessage());
        }
        // 跳转到 message.jsp(转发)
        
        //getServletContext().getRequestDispatcher("/message.jsp").forward(
        //      request, response);
        //转发到DoBase64 servlet(做Base64)
        
        //RequestDispatcher dispatcher = request.getRequestDispatcher("DoBase64");
       // dispatcher.forward(request, response);
      //getServletContext().getRequestDispatcher("DoBase64").forward(request, response);
        //request.getRequestDispatcher("DoBase64").forward(request,response);
        //String Bid = request.getParameter("Bid");
        System.out.print("BidImg:");
        System.out.println(Bid);
        response.sendRedirect("DoBase64?Bid="+Bid);
        }catch(Exception ex){
            PrintWriter out = response.getWriter();
                out.print(ex);
        }
    }
    
       protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
doPost(request,response);

}
}

