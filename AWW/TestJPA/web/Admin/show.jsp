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
        <h1>CUSTOMER LIST</h1>
        <table border="1">
            <tr>
                <td>Customer ID</td>
                <td>Customer Name</td>
                <td>Customer Address</td>
                <td>Action</td>
            </tr>
            <c:forEach  items="${list}" var="c">
                <tr>
                    <td>${c.custId}</td>
                    <td>${c.custName}</td>
                    <td>${c.custaddr}</td>
                    <td><a href="http://localhost:8084/TestJPA/deleteServlet?code=${c.custId}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
