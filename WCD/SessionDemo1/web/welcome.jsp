<%-- 
    Document   : welcome
    Created on : Jan 10, 2020, 10:16:41 AM
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
            String uname = request.getParameter("username");
            out.print("Welcome to "+uname);
            session.setAttribute("uname", uname);
            %>
            <a href="output.jsp">Check output page here</a>
    </body>
</html>
