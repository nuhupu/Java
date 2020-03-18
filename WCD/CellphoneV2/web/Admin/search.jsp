<%-- 
    Document   : search
    Created on : Jan 8, 2020, 11:26:13 AM
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
        <h1>Search book by price</h1>
        <form action="http://localhost:8084/CellphoneV2/searchServlet" method="post">
            <table>
                <tr>
                    <td>Min</td>
                    <td><input type="text" name="min" class="form form-control"></td>
                </tr>
                <tr>
                    <td>Max</td>
                    <td><input type="text" name="max" class="form form-control"></td>
                </tr>
            </table>
            <br>
            <input class="btn btn-primary" type="submit" value="Search"/>
            <input class="btn btn-secondary" type="reset" value="Reset"/>
        </form>
    </body>
</html>
