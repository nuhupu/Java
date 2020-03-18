<%-- 
    Document   : index
    Created on : Jan 10, 2020, 9:05:22 AM
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
        <h1>Hidden Form Field</h1>
        <form action="MyServlet" method="post">
            <input type="hidden" name="job" value="Developer"/>
            Name:<input type="text" name="name"/>
            <input type="submit" value="Submit" />
            
        </form>
    </body>
</html>
