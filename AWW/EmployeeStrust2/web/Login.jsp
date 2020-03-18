<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>LOGIN FORM</h1>
        <s:form action="login" method="post">
            <s:textfield name="username" label="User Name"/>
            <s:password name="password" label="Password"/>
            <s:submit value="Login"/>
            <s:actionerror/>
        </s:form>
    </body>
</html>
