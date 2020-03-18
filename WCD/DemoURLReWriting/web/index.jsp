<%-- 
    Document   : index
    Created on : Jan 10, 2020, 9:41:30 AM
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
        <h1>DEMO URL REWRITING</h1>
        <form action="URLServlet" method="post">
            User Name:<input type="text" name="name"/>
            <br/>
            Password:<input type="password" name="password"/>
            <input type="submit" value="Submit"/>
        </form>
            
        
    </body>
</html>
