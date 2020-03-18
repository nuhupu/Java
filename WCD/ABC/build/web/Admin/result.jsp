<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>LIST EMPLOYEE</h1>
        <table border="1">
            <tr>
                <td>Code</td>
                <td>Name</td>
                <td>Email</td>
                <td>Age</td>
                <td>Salary</td> 
                
            </tr>
            <c:forEach items="${list}" var="cell">
                <tr>
                    <td>${cell.empCode}</td>
                    <td>${cell.empName}</td>
                    <td>${cell.email}</td>
                    <td>${cell.age}</td>
                    <td>${cell.salary}</td>                    
                </tr>
            </c:forEach>
        </table>
        <a href="../index.jsp">Back to home</a>
    </body>
</html>
