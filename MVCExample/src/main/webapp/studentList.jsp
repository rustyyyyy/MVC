<%-- 
    Document   : studentList
    Created on : May 29, 2021, 9:48:44 PM
    Author     : Marut
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.lab.mvcexample.controller.model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body class="container mt-4">
        <h1>Student List</h1>
        <table class="table table-bordered">
            <%
                List<Student> studentlist = (ArrayList) request.getAttribute("studentList");
                for (Student student : studentlist) {
            %>
            <tbody>
                <tr>
                    <td><%= student.getStudentName()%></td>
                    <td><%= student.getStudentAddress()%></td>
                    <!-- For edit and delete --> 
                    <td><a href="StudentController?studentIdForEdit=<%=student.getStudentId()%>"  >Edit</a></td>
                    <td><a href="StudentController?studentIdForDelete=<%=student.getStudentId()%>"  >Delete</a></td>
                </tr>
                <%}%>
            </tbody>
        </table> 
    </body>
</html>
