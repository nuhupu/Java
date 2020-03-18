<%-- 
    Document   : Insert
    Created on : Jan 3, 2020, 8:57:55 AM
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
        <h1>Insert page for admin only</h1>
        <a href="../index.jsp">Back to home</a>
        <form action="../insertServlet" method="post">
            <table border="1">
                <tr>
                    <td>Book code</td>
                    <td><input type="text" name="code"></td>
                </tr>
                <tr>
                    <td>Title</td>
                    <td><input type="text" name="title"></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="text" name="price"></td>
                </tr>
            </table>
            <input type="submit" value="Submit"/>
            <input type="reset" value="Reset"/>
        </form>
    </body>
</html>
