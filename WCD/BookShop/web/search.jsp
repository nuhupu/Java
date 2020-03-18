<%-- 
    Document   : search
    Created on : Jan 15, 2020, 9:18:26 AM
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
        <h1>SEARCH BOOK</h1>
        <form action="searchServlet" >
            <table  border="1">
                <tr>
                    <td>From</td>
                    <td><input type="number" name="from"/></td>
                </tr>
                <tr>
                    <td>To</td>
                    <td><input type="number" name="to"/></td>
                </tr>
            </table>
            <input type="submit" value="Search"/>
        </form>
    </body>
</html>
