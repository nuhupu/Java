<%-- 
    Document   : output
    Created on : Jan 10, 2020, 10:18:18 AM
    Author     : sirac
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
            String name = (String)session.getAttribute("uname");
            out.print("Hello User. You are entered name: "+name);
            %>
    </body>
</html>
