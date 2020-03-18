<%-- 
    Document   : insert
    Created on : Mar 4, 2020, 9:59:35 AM
    Author     : sirac
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Customer</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <s:form action="insert" method="post" theme="simple">
        <table>
            <tr>
                <td>Customer ID</td>
                <td><s:textfield name ="custid"/></td>
            </tr>
             <tr>
                <td>Password</td>
                <td><s:textfield name ="password"/></td>
            </tr>
             <tr>
                <td>Customer Name</td>
                <td><s:textfield name ="custname"/></td>
            </tr>
             <tr>
                <td>Customer Address</td>
                <td><s:textfield name ="custaddr"/></td>
            </tr>
            
        </table>
        <s:submit value="Insert"/>
        <s:fielderror/>
    </s:form>
    </body>
</html>
