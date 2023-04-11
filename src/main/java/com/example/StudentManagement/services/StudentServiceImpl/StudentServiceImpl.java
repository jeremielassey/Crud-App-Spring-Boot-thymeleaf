package com.example.StudentManagement.services.StudentServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.StudentManagement.entities.Student;
import com.example.StudentManagement.repository.StudentRepository;
import com.example.StudentManagement.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepo;

    public StudentServiceImpl(StudentRepository studentR){
        super();
        this.studentRepo = studentR;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }


    @Override
    public Student saveStudent(Student student){
        return studentRepo.save(student);
        
    }

    @Override
    public Student updateStudent(Student student){
        return studentRepo.save(student);
    }

    public Student getStudentById(Long Id){
        return studentRepo.findById(Id).get();
    }
    @Override
    public void deleteStudent(Long id){
        studentRepo.deleteById(id);
    }
    
}
