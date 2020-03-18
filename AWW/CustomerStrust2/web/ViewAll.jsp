<%-- 
    Document   : ViewAll
    Created on : Mar 4, 2020, 9:59:21 AM
    Author     : sirac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer List</title>
    </head>
    <body>
        <h1>Customer List</h1>
        <<table>

            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>Address</td>
            </tr>
            <s:iterator value="list" status="listStatus">
                <tr>
                    <td><s:property value="custId"/></td>
                <td><s:property value="custNam"/></td>
                <td><s:property value="custaddress"/></td>
                <td>
                    <s:url id="deleteURL" action="delete">
                        <s:param name="custId" value="custId"/>
                    </s:url>
                    <s:a href="%{deleteURL}">Delete</s:a>
            </td>
            </tr>
        </s:iterator>

    </table>
</body>
</html>
