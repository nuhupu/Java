<%-- 
    Document   : searchByTitle
    Created on : Jan 15, 2020, 9:35:34 AM
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
        <h1>SEARCH BOOK BY TITLE</h1>
        <form action="searchTitleServlet" >
            Enter title to search <input type="text" name="search"/>
            <input type="submit" value="Search"/>
            
        </form>
    </body>
</html>
