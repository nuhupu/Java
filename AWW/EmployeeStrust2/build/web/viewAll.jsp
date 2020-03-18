<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>SHOW ALL EMPLOYEE</h1>
        <table border="1">
            <tr>
                <td>User Name</td>
                <td>Name</td>
                <td>Address</td>
                <td>Action</td>
            </tr>
            <s:iterator value="list" status="listStatus">
                <tr>
                    <td><s:property value="username"/> </td>
                    <td><s:property value="empname"/> </td>
                    <td><s:property value="empadd"/> </td>
                    <td>
                        <s:url id="deleteURL" action="delete">
                            <s:param name="username" value="username"/>
                        </s:url>
                        <s:a href="%{deleteURL}">Delete</s:a>
                    </td>
                </tr>
            </s:iterator>
        </table>
    </body>
</html>
