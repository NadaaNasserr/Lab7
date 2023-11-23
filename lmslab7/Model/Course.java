package com.example.lmslab7.Model;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;


@Data
@AllArgsConstructor
public class Course {
    //coroues



    @NotEmpty(message = "course id must not be empty")
    @Pattern( regexp ="^\\d{2}$" , message = "course id exactly 2 digits")
    private String id;

    @Pattern(regexp = "[^0-9]*" , message = "Must not contain numbers")
    @NotEmpty(message = "Course Name must not be empty")
    private String courseName;



    @Pattern(regexp = "[^0-9]*" , message = "Must not contain numbers")
    @NotEmpty(message = "Teacher Name must not be empty")
    private String TeacherName;


    @Pattern(regexp = "[^0-9]*" , message = "Must not contain numbers")
    @NotEmpty(message = "category Name must not be empty")
    private String category;



  @NotNull(message = "start CoursesDate cannot be null")
  private LocalDate coursesDate;









}
