<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>LIST CD</h1>
        <table border="1">
            <tr>
                <td>Code</td>
                <td>Name</td>
                <td>Price</td>               
            </tr>
            <c:forEach items="${list}" var="cell">
                <tr>
                    <td>${cell.cdcode}</td>
                    <td>${cell.title}</td>
                    <td>${cell.price}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
