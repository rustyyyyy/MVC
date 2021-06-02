/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.mvcexample.controller;

import com.lab.mvcexample.controller.model.Student;
import com.lab.mvcexample.controller.model.dao.StudentDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marut
 */
public class StudentController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            if (request.getParameter("addStudent") != null && request.getParameter("addStudent").equals("Add")) {
                String studentName = request.getParameter("studentName");
                String studentAddress = request.getParameter("studentAddress");

                Student stud = new Student();
                stud.setStudentName(studentName);
                stud.setStudentAddress(studentAddress);

                StudentDao sd = new StudentDao();
                sd.insertStudent(stud);

                List<Student> studentList = sd.getStudentList();
                request.setAttribute("studentList", studentList);
                RequestDispatcher rd = request.getRequestDispatcher("studentList.jsp");
                rd.forward(request, response);
            } else if (request.getParameter("studentIdForDelete") != null) {
                String studentId = request.getParameter("studentIdForDelete");
                StudentDao sd = new StudentDao();
                sd.deleteStudent(Integer.parseInt(studentId));
                
                List<Student> studentList = sd.getStudentList();
                request.setAttribute("studentList", studentList);
                RequestDispatcher rd = request.getRequestDispatcher("studentList.jsp");
                rd.forward(request, response);
            } else if(request.getParameter("studentIdForEdit") != null){
            
                String studentId = request.getParameter("studentIdForEdit");
                StudentDao sd = new StudentDao();
                Student student = sd.getStudent(Integer.parseInt(studentId));
                request.setAttribute("student", student);
                RequestDispatcher rd = request.getRequestDispatcher("studentForm.jsp");
                rd.forward(request, response);
                
                
            }else if (request.getParameter("addStudent") != null && request.getParameter("addStudent").equals("Edit")) {
                String studentId = request.getParameter("studentId");
                String studentName = request.getParameter("studentName");
                String studentAddress = request.getParameter("studentAddress");

                Student stud = new Student();
                stud.setStudentId(Integer.parseInt(studentId));
                stud.setStudentName(studentName);
                stud.setStudentAddress(studentAddress);

                StudentDao sd = new StudentDao();
                sd.updateStudent(stud);

                List<Student> studentList = sd.getStudentList();
                request.setAttribute("studentList", studentList);
                RequestDispatcher rd = request.getRequestDispatcher("studentList.jsp");
                rd.forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
