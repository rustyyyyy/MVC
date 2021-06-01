/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.mvcexample.controller.model.dao;

import com.lab.mvcexample.controller.model.Student;
import com.lab.mvcexample.controller.utils.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marut
 */
public class StudentDao {

    public void insertStudent(Student student) {
        try {
            Connection con = DbConnection.getConnection();
            String qry = "insert into student(studentName,studentAddress) values(?,?)";
            PreparedStatement ps = con.prepareStatement(qry);
            ps.setString(1, student.getStudentName());
            ps.setString(2, student.getStudentAddress());
            ps.execute();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public List<Student> getStudentList() {
        try {
            List<Student> studentList = new ArrayList<Student>();
            Connection con = DbConnection.getConnection();
            String qry = "select * from student";
            PreparedStatement pst = con.prepareStatement(qry);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                //get ID 
                student.setStudentId(rs.getInt("studentId"));
                student.setStudentName(rs.getString("studentName"));
                student.setStudentAddress(rs.getString("studentAddress"));
                studentList.add(student);
            }
            return studentList;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }
    
    public void deleteStudent(int studentId){
     try {
            Connection con = DbConnection.getConnection();
            String qry = "delete from student where studentId=?";
            PreparedStatement ps = con.prepareStatement(qry);
            ps.setInt(1, studentId);
            ps.execute();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
    
    }
}
