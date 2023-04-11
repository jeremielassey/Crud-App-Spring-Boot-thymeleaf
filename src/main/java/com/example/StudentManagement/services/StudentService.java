package com.example.StudentManagement.services;


import java.util.List;

import com.example.StudentManagement.entities.Student;

public interface StudentService {
    List<Student> getAllStudent();
    public Student saveStudent(Student student);
    public Student updateStudent(Student student);
    public void deleteStudent(Long id);
    public Student getStudentById(Long Id);
}
