<%-- 
    Document   : searchPrice
    Created on : Dec 18, 2019, 11:49:15 AM
    Author     : sirac
--%>

<%@page import="model.cds"%>
<%@page import="model.DAL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            DAL dal = new DAL();
            for (cds cd:dal.searchFromToPrice(
                    Integer.parseInt((request.getAttribute("from")).toString()),
                    Integer.parseInt((request.getAttribute("to")).toString())
                    ))
            %>
            <table border="1">
                 <tr>
        <td><%= cd.getCdCode()%></td>
        <td><%= cd.getTitle()%></td>
        <td><%= cd.getPrice()%></td>
    </tr>
            </table>
   
    <% } %>
    </body>
</html>
