<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>INSERT NEW EMPLOYEE</h1>
        <s:form action="insert" method="post" theme="simple">
            <table border="1">
                <tr>
                    <td>User Name</td>
                    <td><s:textfield name="username"/> </td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><s:password name="password"/> </td>
                </tr>
                <tr>
                    <td>Employee Name</td>
                    <td><s:textfield name="empname"/> </td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><s:textfield name="empadd"/> </td>
                </tr>
                <tr>
                    <td>Roles</td>
                    <td><s:checkbox name="role" label="Admin"/> </td>
                </tr>
                <tr>
                    <td>
                        <s:submit value="Insert"/>
                    </td>
                </tr>
            </table>
            <s:fielderror/>
        </s:form>
    </body>
</html>
