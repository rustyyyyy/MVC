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
    </head>
    <body>
        <h1>Student Form</h1>
        <form action="StudentController" method="post" >
            <% Student student = (Student) request.getAttribute("student");

                if (student == null) {
                    student = new Student();
                    student.setStudentName("");
                    student.setStudentAddress("");
                }
            %>
            <input type="hidden" name="studentId" value="<%=student.getStudentId()%>">
            Student Name: <input type="text" name="studentName" value="<%=student.getStudentName()%>"><br><br>
            Student Address:<input type="text" name="studentAddress" value="<%=student.getStudentAddress()%>"><br>
            <input type="submit" value="<%=student.getStudentId()==0?"Add":"Edit"%>" name="addStudent">
        </form>
    </body>
</html>
