<%-- 
    Document   : Show
    Created on : Dec 18, 2019, 9:34:35 AM
    Author     : sirac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Book List</h1>
        <sql:setDataSource driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
                           url="jdbc:sqlserver://localhost:1433; database=MKBookStore"
                           user="sa"
                           password="123" var="con"
                           />
        <sql:query var="rs" scope="session" dataSource="${con}">
            SELECT *  FROM Book
                
        </sql:query>
            <table border="1">
                
                
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Title</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="row" items="${rs.rows}">
                        <tr>
                            <td>${row.bookCode}</td>
                            <td>${row.title}</td>
                            <td>${row.price}</td>  
                            <td><a href="deleteServlet?code=${row.bookCode}">Delete</a></td>
                        </tr>
                    </c:forEach>                       
                </tbody>
            </table>
    </body>
</html>

