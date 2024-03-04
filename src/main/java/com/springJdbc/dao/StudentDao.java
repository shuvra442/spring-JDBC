package com.springJdbc.dao;

import com.springJdbc.entities.Student;

import java.util.List;

public interface StudentDao {

    public int insert(Student student);
    public int changeDetails(Student student);

    public int deleteDetails(int studentId);

//    select data from database int the form of single object
    public Student getStudentData(int studentId);

    public List<Student> getAllData();
}
