package com.example.lmslab7.Service;


import com.example.lmslab7.Model.Course;
import com.example.lmslab7.Model.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
@Data

public class TeacherService {


 ArrayList<Teacher> teachers = new ArrayList<>();


 public ArrayList<Teacher> getTeachers() {
  return teachers;
 }

 public void addTeacher(Teacher teacher) {
  teachers.add(teacher);
 }

 public boolean updateTeacher(String id, Teacher teacher) {

  for (int i = 0; i < teachers.size(); i++) {
   if (teachers.get(i).getId().equals(id)) {
    teachers.set(i, teacher);
    return true;
   }

  }
  return false;
 }


 public boolean deleteTeacher(String id) {
  for (int i = 0; i < teachers.size(); i++) {
   if (teachers.get(i).getId().equals(id)) {
    teachers.remove(i);
    return true;
   }

  }
  return false;
 }

 public Teacher changeNumberOfCourse(String id, int courumber) {

  for (int i = 0; i < teachers.size(); i++) {
   if (teachers.get(i).getId().equals(id)) {
    teachers.get(i).setNumberOfCourse(courumber);

   }
   return teachers.get(i);

  }

return null;
 }

 public Teacher bonus(String id) {

  for (int i = 0; i < teachers.size(); i++) {
   if (teachers.get(i).getId().equals(id)) {
    if (teachers.get(i).getNumberOfCourse() >= 5) {
     teachers.get(i).setSalary((teachers.get(i).getSalary() *.5 + teachers.get(i).getSalary() ));
     return teachers.get(i);

    }
   }
 }
  return null;
}
}












