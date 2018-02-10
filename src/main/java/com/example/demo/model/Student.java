package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class Student extends Base {

    @Id
    @Field(value = "studentId")
    String studentId;

    @NotNull
    String firstName;

    @NotNull
    String lastName;

    @NotNull
    int age;

    String gender;

    @NotNull
    Address address;

    Grade grade;

}
