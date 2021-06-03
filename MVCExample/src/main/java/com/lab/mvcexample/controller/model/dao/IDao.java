/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.mvcexample.controller.model.dao;

import com.lab.mvcexample.controller.model.Student;
import java.util.List;

/**
 *
 * @author Marut
 */
public interface IDao {

    void deleteStudent(int studentId);

    Student getStudent(int studentId);

    List<Student> getStudentList();

    void insertStudent(Student student);

    void updateStudent(Student student);
    
}
