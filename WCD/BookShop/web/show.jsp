<%-- 
    Document   : show
    Created on : Jan 15, 2020, 8:44:07 AM
    Author     : sirac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>BOOK LIST</h1>
        <table border="1">
            <tr>
                <td>Book Code</td>
                <td>Title</td>
                <td>Price</td>
                <td>Action</td>
            </tr>
            <c:forEach  items="${list}" var="b">
                <tr>
                    <td>${b.bookId}</td>
                    <td>${b.title}</td>
                    <td>${b.price}</td>
                    <td><a href="deleteServlet?code=${b.bookId}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
