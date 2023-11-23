package com.example.lmslab7.Model;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {



    @NotEmpty(message = "Teacher id must not be empty")
    @Pattern( regexp ="^\\d{5}$" , message = "exactly 5 digits")
    private String id;


    @Pattern(regexp = "[^0-9]*" , message = "Must not contain numbers")
    @NotEmpty(message = "Teacher Name must not be empty")
    private String TeacherName;


    @Pattern( regexp ="^05\\d{8}$" , message = "Must start with 05 and consists of exactly 10 digits")
    @NotEmpty(message = "Phone Number Name must not be empty")
    private String phoneNumber;

    @NotEmpty(message = "Email must not be empty")
    @Email (message = "Must be a valid email format")
    private String email;

    @NotEmpty(message = "Course Number must not be empty")
    @Positive(message = "Must contain numbers")
    private int numberOfCourse;

    @NotEmpty(message = "salary Number must not be empty")
    @Positive(message = "salary Must contain numbers")
    private double salary;



}
