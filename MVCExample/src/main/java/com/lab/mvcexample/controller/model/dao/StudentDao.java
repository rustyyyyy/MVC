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
                //get ID setIdstudent(rs.getInt("id"));
                student.setStudentId(rs.getInt("id"));
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
    
    public void deleteStudent(int id){
     try {
            Connection con = DbConnection.getConnection();
            String qry = "delete from student where id=?";
            PreparedStatement ps = con.prepareStatement(qry);
            ps.setInt(1, id);
            ps.execute();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
    
    }
    
    public Student getStudent(int id){
      try {
           Student student = new Student();
            Connection con = DbConnection.getConnection();
            String qry = "select * from student where id=?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                student.setStudentId(rs.getInt("id"));
                student.setStudentName(rs.getString("studentName"));
                student.setStudentAddress(rs.getString("studentAddress"));
               
            }
            return student;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    
    }
    
    public void updateStudent(Student student){
     try {
            Connection con = DbConnection.getConnection();
            String qry = "update student set studentName=? ,studentAddress=? where id=?";
            PreparedStatement ps = con.prepareStatement(qry);
            ps.setString(1, student.getStudentName());
            ps.setString(2, student.getStudentAddress());
            ps.setInt(3, student.getStudentId());
            ps.execute();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
    
    
    
    }
}
