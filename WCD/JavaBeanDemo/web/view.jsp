<%-- 
    Document   : view
    Created on : Feb 24, 2020, 10:22:36 AM
    Author     : sirac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="login" scope="session"
                     class="bean.ProcessBean"/>
        <font color="red">
        Welcome ${login.username}
        </font><br/>
        <h1>USER INFORMATION</h1>
        <form>
            User Name
            <input type="text" name="txtSearch"/>
            <input type="submit" value="Search"/>
        </form>
        <sql:setDataSource
            driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
            url="jdbc:sqlserver//localhost:1433;database=useraccrount"
            user="sa" password="123" var="con"
            />
        <sql:query dataSource="${con}" var="rs">
            select*from users where username like ?
            <sql:param value="%${param.txtSearch}%"/>            
        </sql:query>
            <c:if test="${not empty rs}">
                <table border="1"
                       <thead>
                        <tr>
                            <th>No.</th>
                            <th>User Name</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="row" items="${rs.row}">
                            <tr>
                                <c:set var="count" value="${count+1}"/>
                                <td>${count}</td>
                                <c:set value = "${row.username}" 
                                       var="username"/>
                                <td>${username}</td>
                                <td>
                                    <a href="viewdetail.jsp?username=${uername}">View Detail
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
            </c:if>
                   
    </body>
</html>
