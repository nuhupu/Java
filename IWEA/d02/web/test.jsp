<%-- 
    Document   : test
    Created on : Dec 11, 2019, 11:31:33 AM
    Author     : nuhupu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h2>Calculator web demo</h2>
        <form action="calServlet" method="post">
            <table border="1">
                <tr>
                    <td>First number</td>
                    <td><input type="text" name="n1"></td>
                </tr>
                <tr>
                    <td>Second number</td>
                    <td><input type="text" name="n2"></td>
                </tr>
            </table>
            </br>
            <input type="submit" value="Add" name="action"/>
            <input type="submit" value="Sub" name="action"/>
            <input type="submit" value="Mul" name="action"/>
            <input type="submit" value="Divide" name="action"/>
        </form>
    </body>
</html>
