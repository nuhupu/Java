<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>LIST CELL PHONE</h1>
        <table border="1">
            <tr>
                <td>Code</td>
                <td>Name</td>
                <td>Price</td>
                <td>Manufacturer</td>
           
                
            </tr>
            <c:forEach items="${list}" var="cell">
                <tr>
                    <td>${cell.cellCode}</td>
                    <td>${cell.cellName}</td>
                    <td>${cell.price}</td>
                    <td>${cell.manufacturer}</td>
                    
                </tr>
            </c:forEach>
        </table>
         <a href="insert.jsp">Go to insert</a>
        <a href="../index.jsp">Back to home</a>
    </body>
</html>
