package com.example.demo.controller;

import com.example.demo.constants.ApiConstant;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = ApiConstant.STUDENTS, method = RequestMethod.POST)
    public ResponseEntity<?> addStudent(@RequestHeader(value = ApiConstant.PARAM_USER_ID_HEADER) String userId,
                                        @RequestBody Student student) {
        return new ResponseEntity<>(studentService.addStudent(userId, student), HttpStatus.CREATED);
    }

    @RequestMapping(value = ApiConstant.STUDENTS, method = RequestMethod.GET)
    public ResponseEntity<?> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }
}
