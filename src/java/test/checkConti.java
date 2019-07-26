/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class checkConti extends HttpServlet {

 
    protected void doPost(HttpServletRequest request,HttpServletResponse response) 
             throws ServletException,IOException {
              response.setContentType("text/html;charset=UTF-8");
              try(PrintWriter out=response.getWriter()){
                  
                  
                  
                  
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
