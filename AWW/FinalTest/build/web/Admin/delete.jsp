<%-- 
    Document   : show
    Created on : Jan 15, 2020, 8:44:07 AM
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
        <h1>EMPLOYEE LIST</h1>
        <sql:setDataSource driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
                           url="jdbc:sqlserver://localhost:1433; database=employees"
                           user="sa"
                           password="123" var="con"
                           />
        <sql:query var="rs" scope="session" dataSource="${con}">
            SELECT *  FROM employee

        </sql:query>
        <table id="tb" border="1">                                
            <thead>
                <tr>
                    <th>Employee ID</th>
                    <th>Employee Name</th>
                    <th>Phone</th>
                    <th>Job</th>
                    <th>Salary</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="row" items="${rs.rows}">
                    <tr>
                        <td>${row.employeeid}</td>
                        <td>${row.employeename}</td>
                        <td>${row.phone}</td>  
                        <td>${row.job}</td>  
                        <td>${row.salary}</td>  

                    </tr>
                </c:forEach>                       
            </tbody>
        </table>

        <form action="http://localhost:8084/FinalTest/delete">                                   
            <table border ="1">
                <tr>
                    <td>
                        Enter employee ID
                    </td>
                    <td>
                        <input type="text" name="employeeid"/>
                    </td>
                </tr>

            </table>

            <input type="submit" value="Delete"/>
            <input type="reset" value="Reset"/>
        </form>
    </body>
</html>
