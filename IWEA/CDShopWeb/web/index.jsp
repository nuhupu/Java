<%-- 
    Document   : index
    Created on : Dec 18, 2019, 8:40:26 AM
    Author     : sirac
--%>
<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="color: green">CD SHOP ONLINE</h1>
        <a href="insert.jsp">Insert</a>
        <form action="searchServlet">                                   
            <table border ="1">
                <tr>
                    <td>
                        From
                    </td>
                    <td>
                         <input type="text" name="from"/>
                    </td>
                </tr>
                 <tr>
                    <td>
                        To
                    </td>
                    <td>
                         <input type="text" name="to"/>
                    </td>
                </tr>
        </table>
            <input type="submit" value="Search"/>
        </form>
        
    </body>
</html>
