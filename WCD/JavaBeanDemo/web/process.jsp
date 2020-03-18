
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <h1>Hello World!</h1>
    <body>
        <jsp:useBean id="login" class="bean.processBean"
                     scope="session"/>
        <jsp:setProperty name="login" property="*"/>
        <c:if test="${login.checkLogin}">
            <c:redirect url="view.jsp"/>            
        </c:if>
        <c:if test ="${not login.checkLogin}" >
            <h1 style="color: red">Invalid username or password</h1>
            <h2>Click<a href="index.jsp"</h2>
    </body>
</html>
