package com.example.lmslab7.Service;

import com.example.lmslab7.Model.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Service
@Data
@AllArgsConstructor
public class CourseService {


    ArrayList<Course> courses = new ArrayList<>();

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {

        courses.add(course);
    }

    public boolean updateCourse(String id, Course course) {

        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId().equals(id)) {
                courses.set(i, course);
                return true;
            }

        }
        return false;
    }

    public boolean deleteCourse(String id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId().equals(id)) {
                courses.remove(i);
                return true;
            }
        }
        return false;
    }


    public ArrayList<Course> getCategory(String category) {
        ArrayList<Course> courses1 = new ArrayList<>();


        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCategory().equals(category)) {
                courses1.add(courses.get(i));

            }
        }
        return courses1;
    }

    public ArrayList<Course> courseDate(LocalDate date) {
        ArrayList<Course> courses1 = new ArrayList<>();

        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCoursesDate().equals(date)) {
                courses1.add(courses.get(i));
            }
        }
        return courses1;
    }





}







