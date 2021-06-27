/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.mvcexample.controller;
/**
 *
 * @author rusty
 */
public class AddCommand implements Command {

    public Integer execute() {
        String studentName = request.getParameter("studentName");
        String studentAddress = request.getParameter("studentAddress");

        Student stud = new Student();
        stud.setStudentName(studentName);
        stud.setStudentAddress(studentAddress);

        IDao sd = new StudentDao();
        sd.insertStudent(stud);

        List<Student> studentList = sd.getStudentList();
        request.setAttribute("studentList", studentList);
        RequestDispatcher rd = request.getRequestDispatcher("studentList.jsp");
        rd.forward(request, response);
    }
}
