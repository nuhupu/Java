<%-- 
    Document   : insert
    Created on : Dec 18, 2019, 8:51:20 AM
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
        <h1 style="color: red">INSERT NEW CD</h1>
        <form action="insertServlet" method="post">
            <table border="1">
                <tr>
                    <td>Code</td><td><input type="text" name="code"/></td>


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
            <input type="submit" value="Submit"/>
            <input type="reset" value="Reset"/>
        </form>
    </body>
</html>
