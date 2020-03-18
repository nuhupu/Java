<%-- 
    Document   : insert
    Created on : Jan 15, 2020, 8:33:19 AM
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
        <h1>INSERT NEW BOOK</h1>
        <form action="insertServlet" method="post">
            <table border="1">
                <tr>
                    <td>Book Code</td>
                    <td><input type="text" name="bookCode"/></td>
                </tr>
                <tr>
                    <td>Title</td>
                    <td><input type="text" name="title"/></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="text" name="price"/></td>
                </tr>
            </table>
            <input type="submit" value="Insert"/>
            <input type="reset"  value="Reset"/>
        </form>
    </body>
</html>
