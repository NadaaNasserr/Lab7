package com.example.lmslab7.Controller;


import com.example.lmslab7.Model.Course;
import com.example.lmslab7.Model.Teacher;
import com.example.lmslab7.Service.CourseService;
import com.example.lmslab7.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@AllArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;


    @GetMapping("/get")
    public ResponseEntity getTeacher() {

        return ResponseEntity.status(200).body(teacherService.getTeachers());
    }


    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(HttpStatus.OK).body("teacher added");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable String id, @Valid @RequestBody Teacher teacher, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean isUpdated = teacherService.updateTeacher(id, teacher);
        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK).body("teacher updated");

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong id");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable String id) {


        boolean isDeleted = teacherService.deleteTeacher(id);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body("teacher Deleted");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong id");
    }


    @PutMapping("/changecournumber/{id}/{courumber}")
    public ResponseEntity changeNumberOfCourse(@PathVariable  String id, @PathVariable int courumber){
        if(teacherService.changeNumberOfCourse(id,courumber) == null){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("dd");
        }
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.changeNumberOfCourse(id,courumber));
    }

    @PutMapping("/salary/{id}")
    public ResponseEntity bonus(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.bonus(id));

    }
}
