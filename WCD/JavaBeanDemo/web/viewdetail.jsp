<%-- 
    Document   : viewdetail
    Created on : Feb 24, 2020, 10:57:09 AM
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
                     class="bean.processBean"/>
        <font color="red">Welcome ${login.username}</font>
        <h2>INFOMATION DETAIL</h2>
        <sql:setDataSource
            driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
            url="jdbc:sqlserver//localhost:1433;database=useraccrount"
            user="sa" password="123" var="con"
            />
        <sql:query dataSource="${con}" var="rs">
            select*from users where username = ?
            <sql:param value="%${param.username}%"/>            
        </sql:query>
            <sql:query dataSource="${con}" var="rs2">
            select*from users where username = ?
            <sql:param value="%${login.username}%"/>            
        </sql:query>
            <c:forEach var="dong" items="${rs2.rows}">
                <c:set var="admin" value="${dong.isAdmin}"/>
            </c:forEach>
            <c:if test="${admin or
                          (login.username eq param.username)}">
                <c:forEach var="row" items="${rs.rows}">
                    User Name: ${row.username}</br>
                    Last Name: ${row.lastname}</br>
                    <c:if test="${row.isAdmin}">
                        <c:set var="role" value="Admin"/>
                    </c:if>
                    <c:if test="${not row.isAdmin}">
                        <c:set var="role" value="User"/>
                    </c:if>
                    Role:${role}</br>
                    Click<a href="view.jsp">here</a> to return search page!
                </c:forEach>
            </c:if>
                    <c:if test="${not row.isAdmin and 
                          (login.username!=param.username)}">
                          No permision to access
                        <c:set var="role" value="User"/>
                        Click<a href="view.jsp">here</a> to return search page!
                    </c:if>
    </body>
</html>
