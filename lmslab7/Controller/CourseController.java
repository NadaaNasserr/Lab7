package com.example.lmslab7.Controller;

import com.example.lmslab7.Model.Course;
import com.example.lmslab7.Service.CourseService;
import com.example.lmslab7.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/course")
@AllArgsConstructor

public class CourseController {

    private final CourseService courseService;


    @GetMapping("/get")
    public ResponseEntity getCourses() {

        return ResponseEntity.status(200).body(courseService.getCourses());
    }


    @PostMapping("/add")
    public ResponseEntity addCourses(@Valid @RequestBody Course course, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        courseService.addCourse(course);
        return ResponseEntity.status(HttpStatus.OK).body("course added");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateCourses(@PathVariable String id, @Valid @RequestBody Course course, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean isUpdated = courseService.updateCourse(id, course);
        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK).body("course updated");

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong id");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourses(@PathVariable String id) {


        boolean isDeleted = courseService.deleteCourse(id);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body("course Deleted");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong id");
    }

    @GetMapping("/getcategory/{category}")
    public ResponseEntity getCategory(@PathVariable String category){
        if(courseService.getCategory(category).isEmpty()){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong category");

        }

        return ResponseEntity.status(HttpStatus.OK).body(courseService.getCategory(category));
    }


    @GetMapping("/courseDate/{date}")
    public ResponseEntity courseDate(@PathVariable LocalDate date){
        ArrayList c = courseService.courseDate(date);
        if(c.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("no course start on this date");

        }
        return ResponseEntity.status(HttpStatus.OK).body(courseService.courseDate(date));
    }



}
