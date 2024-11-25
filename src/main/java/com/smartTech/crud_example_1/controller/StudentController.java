package com.smartTech.crud_example_1.controller;

import com.smartTech.crud_example_1.entity.Student;
import com.smartTech.crud_example_1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
  @Autowired
  private StudentService studentService;
  @PostMapping("/add")
  public ResponseEntity<Student> createStudent(@RequestBody Student student){
    Student newStudent = studentService.createStudentService(student);
    return ResponseEntity.ok(newStudent);
  }

  @PostMapping("/addAll")
  public ResponseEntity<List<Student>> createStudentBulk(@RequestBody List<Student> students){
    List<Student> newStudents = studentService.createStudentBulkService(students);
    return ResponseEntity.ok(newStudents);
  }
  @PutMapping("/update")
  public ResponseEntity<Student> updateStudent(@RequestBody Student student){
    Student updatedStudent = studentService.updateStudentService(student);
    return ResponseEntity.ok(updatedStudent);
  }
  @DeleteMapping("Delete")
  public ResponseEntity<String> deleteStudent(@PathVariable int id){
    String status = studentService.deleteStudentService(id);
    return ResponseEntity.ok(status);
  }

  @GetMapping("")
  public ResponseEntity<List<Student>> getAllStudents(){
    List<Student> students = studentService.getAllStudentsService();
    return ResponseEntity.ok(students);
  }

  @GetMapping("/assign/student/{studentId}/course/{courseId}")
  public ResponseEntity<Student> assignCourseToStudent(@PathVariable int studentId,@PathVariable int courseId){
    Student assignedStudent = studentService.assignCourseToStudentService(studentId,courseId);
    return ResponseEntity.ok(assignedStudent);
  }
}
