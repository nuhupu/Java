<%-- 
    Document   : edit
    Created on : Jan 8, 2020, 10:51:07 AM
    Author     : nhozk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <style>
            th, td{
                padding: 5px;
            }
        </style>
    </head>
    <body>
        <h1 style="color: red">EDIT CELLPHONE. THIS PAGE IS FOR ADMIN ONLY</h1>
        <form action="http://localhost:8084/CellphoneV2/updateServlet" method="post">
            <input type="hidden" name="code" value="${book.cellCode}"/>
            <table border="1">
                <tr>
                    <td>Cellphone Name:</td>
                    <td><input type="text" name="name" value="${book.cellName}" required="" class="form form-control"/></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="number" name="price" value="${book.price}" min="0" required="" class="form form-control"/></td>
                </tr>
                <tr>
                    <td>Manufacturer:</td>
                    <td><input type="text" name="man" value="${book.manufacturer}" required="" class="form form-control"/></td>
                </tr>
            </table>
            <br>
            <input class="btn btn-success" type="submit" value="Update"/>
        </form>
    </body>
</html>
