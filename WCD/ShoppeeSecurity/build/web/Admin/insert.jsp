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
                <td>Book Id</td>
                <td><input type="text" name="id" id="code"  oninput="handleInput(this)">
                    <div id="invalid-code" style="color: red" class="invalid-feedback"></div>
                </td>
                 
            </tr>
            <tr>
                <td>Title</td>
                <td><input type="text" name="title" id="title" oninput="handleInput(this)">
                <div id="invalid-title" style="color: red;display: block;" class="invalid-feedback"></div>
                </td>
                 
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="number" name="price" id="price" oninput="handleInput(this)">
                <div id="invalid-price" style="color: red;display: block;" class="invalid-feedback"></div>
                </td>
            
            </tr>
                </table>
            <input type="submit" value="Insert"/>
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
                return errors[input.id] = "Not null";
           if (input.value.length < 6) return errors[input.id] = "Book code must contains at least 6 characters";
            delete errors[input.id];
        }
        
        if (input.id === "title") {
            if (input.value === "")
                return errors[input.id] = "Not null";
           if (input.value.length < 6) return errors[input.id] = "Title must contains at least 6 characters";
            delete errors[input.id];
        }
        
        if (input.id === "price") {
            if (input.value === "")
                return errors[input.id] = "Not null";
           if (input.value < 50) return errors[input.id] = "Price must greater than 50";
            delete errors[input.id];
        }
    }
    
    const handleInputForm = async e => {
                e.preventDefault();
                var validateElement = document.querySelectorAll('form #form input[oninput]');
                validateElement.forEach(element => handleInputPopup(element));
                if (Object.keys(errors).length === 0)
                    console.log("OK");
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
    form.addEventListener("submit", handleInputForm);
</script>
