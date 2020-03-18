<%-- 
    Document   : insert
    Created on : Jan 8, 2020, 8:54:26 AM
    Author     : sirac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="color:red">INSERT PAGE FOR ADMIN ONLY</h1>
        <form action="../Admin/insertServlet" method="post" id="form">
            <table border="1">
                <tr>
                    <td>Cellphone Name</td>
                    <td><input type="text" name="name" id="code"  oninput="handleInput(this)">
                        <div id="invalid-code" style="color: red" class="invalid-feedback"></div>
                    </td>

                </tr>          
                <tr>
                    <td>Price</td>
                    <td><input type="number" name="price" id="price" oninput="handleInput(this)">
                        <div id="invalid-price" style="color: red;display: block;" class="invalid-feedback"></div>
                    </td>

                </tr>
                <tr>
                    <td>Manufacturer</td>
                    <td>
                        <input type="radio" name="manufacturer" value="nokia" >Nokia</br>
                        <input type="radio" name="manufacturer" value="samsung">Samsung</br>
                        <input type="radio" name="manufacturer" value="iphone">Iphone</br> 
                        <input type="text" name="manufacturer" id="manufacturer" oninput="handleInput(this)" placeholder="Another">
                        <div id="invalid-manufacturer" style="color: red;display: block;" class="invalid-feedback"></div>
                    </td>

                </tr>
            </table>
            <input type="submit" value="Insert"/>
            <input type="reset" value="Reset"/>
        </form>
    </body>
</html>