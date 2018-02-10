package com.example.demo.repository;

import com.example.demo.constants.ApiConstant;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * @param student
     * @return
     */
    public Student addStudent(Student student) {
        mongoTemplate.insert(student, ApiConstant.MONGO_STUDENT_COLLECTION);
        return student;
    }

    /**
     * Get all students
     *
     * @return
     */
    public List<Student> getAllStudents() {
        return mongoTemplate.findAll(Student.class, ApiConstant.MONGO_STUDENT_COLLECTION);
    }
}
