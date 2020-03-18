<%-- 
    Document   : Insert
    Created on : Jan 3, 2020, 8:57:55 AM
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
        <h1>Insert employee</h1>
        <a href="../index.jsp">Back to home</a>
        <form action="../Admin/insertServlet" method="post" id="form">
            <table border="1">
                <tr>
                    <td>Employee code</td>
                    <td>
                        <input type="text" name="code" id="code" oninput="handleInput(this)" />
                        <div id="invalid-code" style="color: red" class="invalid-feedback"></div>
                    </td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name" id="name" oninput="handleInput(this)" />
                        <div id="invalid-name" class="invalid-feedback" style="display: block;"</td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="email" name="email" id="email" oninput="handleInput(this)" />
                        <div id="invalid-email" class="invalid-feedback" style="display: block;"</td>
                </tr>
                <tr>
                    <td>Age</td>
                    <td><input type="number" name="age" id="age" oninput="handleInput(this)" />
                        <div id="invalid-age" class="invalid-feedback" style="display: block;"</td>
                </tr>
                <tr>
                    <td>Salary</td>
                    <td><input type="number" name="salary" id="salary" oninput="handleInput(this)" />
                        <div id="invalid-salary" class="invalid-feedback" style="display: block;"</td>
                </tr>
            </table>
            <input type="submit" value="Submit"/>
            <input type="reset" value="Reset"/>
        </form>
    </body>
</html>
<script>
    const form = document.getElementById('form');
    const errors = {};
    var validateInput = (input) => {
        if (input.id === "code") {
            if (input.value === "")
                return errors[input.id] = "Cần phải nhập số lượng phiếu";
            if (parseInt(input.value) != input.value)
                return errors[input.id] = "Chỉ được nhập số"
            delete errors[input.id];
        }
    }
    var handleInput = element => {
        validateInput(element)
        if (errors[element.id]) {
            element.nextElementSibling.style.display = "block";
            element.nextElementSibling.innerText = errors[element.id]
        } else {
            element.nextElementSibling.style.display = "none";
        }
    }
    form.addEventListener("submit", handleUpdateTicket);
</script>