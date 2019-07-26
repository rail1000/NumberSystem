<%-- 
    Document   : TEMP
    Created on : 2019-7-23, 21:57:56
    Author     : Windows10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        String a = "00010";
        String b = "00015";
        int A = Integer.parseInt(a);
        int B = Integer.parseInt(b);
        A = A+1;
        B = B+1;
        %>
        <h1><%=A%><br>
            <%=B%>
            
            
        </h1>
    </body>
</html>
