<%-- 
    Document   : studentForm.jsp
    Created on : May 29, 2021, 12:35:03 PM
    Author     : Marut
--%>

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
        <h1>Student Form</h1>
        <form class="form-inline"    action="StudentController" method="post" >
            <% Student student = (Student) request.getAttribute("student");

                if (student == null) {
                    student = new Student();
                    student.setStudentName("");
                    student.setStudentAddress("");
                }
            %>
            <input type="hidden" name="studentId" value="<%=student.getStudentId()%>">
            <label  class="mb-2 mr-sm-2">Student Name:</label>
            <input class="form-control mb-2 mr-sm-2" type="text" name="studentName" value="<%=student.getStudentName()%>">
            <label  class="mb-2 mr-sm-2">Student Address:</label>
            <input Student Name: type="text" name="studentAddress" value="<%=student.getStudentAddress()%>">
            <input class="btn btn-primary mb-2 ml-4" type="submit" value="<%=student.getStudentId() == 0 ? "Add" : "Edit"%>" name="addStudent">
        </form>
    </body>
</html>
