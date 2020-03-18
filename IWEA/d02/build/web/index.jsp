<%-- 
    Document   : index
    Created on : Dec 11, 2019, 10:03:16 AM
    Author     : nuhupu
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
        <h1>Hello World!</h1>
        <c:forEach var="i" begin="1" end="10">
            <c:out value="${i}"></c:out>
        </c:forEach>
        <p><b>Using format Date</b></p>
        <c:set var="now" value="<%=new java.util.Date()%>" />
            <p>Formatted Date: <fmt:formatDate type="date" value="${now}"/></p>
            <p><b>Using for tokens</b></p>
            <c:forTokens var="name" items="Phuc,My,An,Tram" delims=",">
                <c:out value="${name}"></c:out>
            </c:forTokens>
        <p><b>Using choose</b></p>    
        <c:set var="price" scope="session" value="${200*2}"/>
        <p>Product price is: <c:out value ="$price}"/></p>
        <c:choose>
            <c:when test="${price <=0}">
                The product is for free
            </c:when>
            <c:when test="${price <1000}">
                Price is normal
            </c:when>
            <c:otherwise>
                Price is very high
            </c:otherwise>
        </c:choose>
        <p><b>Using import</b></p>
        <c:import var="data" url="https://nld.com.vn/"/>
        <c:out value="${data}"/>
    </body>
</html>
