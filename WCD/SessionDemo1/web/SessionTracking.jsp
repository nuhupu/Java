<%-- 
    Document   : SessionTracking
    Created on : Jan 10, 2020, 10:39:46 AM
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
        <h1>Session tracking demo</h1>
        <table border="1" align="center">
            <tr bbcolor="cyan">
                <th>Session info</th>
                <th>Value</th>
            </tr>
            <tr>
                <td>Id</td>
                <td><% out.print(session.getId());%></td>                
            </tr>
             <tr>
                <td>Time of Acces</td>
                <td><% out.print(session.getLastAccessedTime());%></td>                
            </tr>
             <tr>
                <td>Number of visits</td>
                <td><% out.print(session.getCreationTime());%></td>                
            </tr>
        </table>
    </body>
</html>
