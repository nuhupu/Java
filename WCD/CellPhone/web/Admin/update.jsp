<%-- 
    Document   : insert
    Created on : Jan 8, 2020, 8:54:26 AM
    Author     : sirac
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="color:red">Update</h1>  
        <c:forEach items="${list}" var="cell">
            <form action="../Admin/updateServlet" method="post" id="form">
                <table border="1">

                    <tr>
                        <td>Cellphone Code</td>
                        <td><input type="text" name="code" value="${cell.cellCode}" disabled="true" oninput="handleInput(this)">
                            <div id="invalid-code" style="color: red" class="invalid-feedback"></div>
                        </td>

                    </tr>
                    <tr>
                        <td>Cellphone Name</td>
                        <td><input type="text" name="name" value="${cell.cellName}"  oninput="handleInput(this)">
                            <div id="invalid-code" style="color: red" class="invalid-feedback"></div>
                        </td>

                    </tr>          
                    <tr>
                        <td>Price</td>
                        <td><input type="number" name="price" value="${cell.price}" oninput="handleInput(this)">
                            <div id="invalid-price" style="color: red;display: block;" class="invalid-feedback"></div>
                        </td>

                    </tr>
                    <tr>
                        <td>Manufacturer</td>
                        <td>                  
                            <input type="text" name="manufacturer" value="${cell.manufacturer}" oninput="handleInput(this)" placeholder="">
                            <div id="invalid-manufacturer" style="color: red;display: block;" class="invalid-feedback"></div>
                        </td>

                    </tr>


                </table>
                <input type="submit" value="Update"/>
                <input type="reset" value="Reset"/>
            </form>
        </c:forEach>
    </body>
</html>