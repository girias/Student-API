package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    /**
     * @param student
     * @return
     */
    public Student addStudent(String userId, Student student) {
        student.setUserId(userId);
        student.setDocumentDate();
        return studentRepository.addStudent(student);
    }

    /**
     * @return
     */
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }
}
