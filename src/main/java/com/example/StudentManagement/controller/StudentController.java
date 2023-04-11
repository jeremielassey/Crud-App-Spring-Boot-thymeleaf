package com.example.StudentManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.StudentManagement.entities.Student;
import com.example.StudentManagement.services.StudentService;



@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentS){
        super();
        this.studentService = studentS;
    }
    
    @GetMapping("/Student")
    public String listStudent( Model model){
        model.addAttribute("Student",studentService.getAllStudent());
        return "Student";
    }

    @GetMapping("/Student/new")
    public String createStudent(Model model) {
        Student student = new Student();
        model.addAttribute("Student", student);
        return "create_Student";
    }

    @PostMapping("/Student")
    public String saveStudent(@ModelAttribute("Student")Student student){
        studentService.saveStudent(student);
        return "redirect:/Student";

    }

    @GetMapping("/Student/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model){
        model.addAttribute("Student",studentService.getStudentById(id));
        return "edit_Student";
    }

@PostMapping("/Student/{id}")
public String update(@PathVariable Long id,@ModelAttribute("Student") Student student,Model model){
    Student studentExist = studentService.getStudentById(id);
    studentExist.setId(id);
    studentExist.setNom(student.getNom());
    studentExist.setPrenom(student.getPrenom());
    studentExist.setEmail(student.getEmail());

    studentService.updateStudent(studentExist);
    return "redirect:/Student";
}

@GetMapping("/Student/{id}")
public String deleteStudent(@PathVariable Long id){
    studentService.deleteStudent(id);
    return "redirect:/Student";
}

}
