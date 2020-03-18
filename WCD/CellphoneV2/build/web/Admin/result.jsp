<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <h1>View All Cellphone</h1>

        <p></p>
        <table border="1">
            <tr>
                <th>Cellphone Code</td>
                <th>Cellphone Name</td>
                <th>Price</td>
                <th>Manufacturer</td>
            </tr>
            <c:forEach items="${list}" var="item">
                <tr>
                    <td>${item.cellCode}</td>
                    <td>${item.cellName}</td>
                    <td>${item.price}</td>
                    <td>${item.manufacturer}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <a class="btn btn-warning" href="http://localhost:8084/CellphoneV2/index.jsp">Back to index</a>
    </body>
</html>