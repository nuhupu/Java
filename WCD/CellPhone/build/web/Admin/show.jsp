<%-- 
    Document   : show
    Created on : Jan 6, 2020, 9:47:18 AM
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
        <h1>Cellphone list</h1>
        <sql:setDataSource driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
                           url="jdbc:sqlserver://localhost:1433; database=CellPhoneDB"
                           user="sa"
                           password="123" var="con"
                           />
        <sql:query var="rs" scope="session" dataSource="${con}">
            SELECT *  FROM cellphone

        </sql:query>
        <table id="tb" border="1">                                
            <thead>
                <tr>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Manufacturer</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="row" items="${rs.rows}">
                    <tr>
                        <td>${row.cellCode}</td>
                        <td>${row.cellName}</td>
                        <td>${row.price}</td>  
                        <td>${row.manufacturer}</td>                           
                        <td>
                            <a href="../Admin/deleteServlet?code=${row.cellCode}">Delete</a>|
                            <a href="../Admin/selectOneCPServlet?code=${row.cellCode}">Update</a>
                        </td>
                    </tr>
                </c:forEach>                       
            </tbody>
        </table>
        <form action="../Admin/searchServlet">                                   
            <table border ="1">
                <tr>
                    <td>
                        From
                    </td>
                    <td>
                        <input type="text" name="from"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        To
                    </td>
                    <td>
                        <input type="text" name="to"/>
                    </td>
                </tr>
            </table>
            <input type="submit" value="Search"/>
        </form>
        <a href="insert.jsp">Go to insert</a>
        <a href="../index.jsp">Back to Home</a>
    </body>
</html>

