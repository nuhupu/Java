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
        <h1>INSERT NEW CUSTOMER</h1>
        <form action="http://localhost:8084/TestJPA/insertServlet" method="post">
            <table border="1">
                <tr>
                    <td>Customer ID</td>
                    <td><input type="text" name="custId"/></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="text" name="password"/></td>
                </tr>
                <tr>
                    <td>Customer Name</td>
                    <td><input type="text" name="custName"/></td>
                </tr>
                <tr>
                    <td>Customer Address</td>
                    <td><input type="text" name="custaddr"/></td>
                </tr>
            </table>
            <input type="submit" value="Insert"/>
            <input type="reset"  value="Reset"/>
        </form>
    </body>
</html>
