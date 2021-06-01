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
    </head>
    <body>
        <h1>Student List</h1>
        <table>
        <%
            List<Student> studentlist = (ArrayList) request.getAttribute("studentList");
            for(Student student:studentlist){
            %>
            
                <tr>
                    <td><%= student.getStudentName() %></td>
                    <td><%= student.getStudentAddress() %></td>
                    <!-- For edit and delete --> 
                    <td><a href="StudentController?studentIdForEdit=<%=student.getStudentId()%>"  >Edit</a></td>
                    <td><a href="StudentController?studentIdForDelete=<%=student.getStudentId()%>"  >Delete</a></td>
                </tr>
                <%}%>
            </table> 
    </body>
</html>
