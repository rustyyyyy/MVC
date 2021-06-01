<%-- 
    Document   : studentForm.jsp
    Created on : May 29, 2021, 12:35:03 PM
    Author     : Marut
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Student Form</h1>
        <form action="StudentController" method="post" >
            Student Name: <input type="text" name="studentName"><br><br>
            Student Address:<input type="text" name="studentAddress"><br>
            <input type="submit" value="Add" name="addStudent">
        </form>
    </body>
</html>
