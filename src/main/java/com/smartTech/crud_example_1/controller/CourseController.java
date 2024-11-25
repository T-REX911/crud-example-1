package com.smartTech.crud_example_1.controller;

import com.smartTech.crud_example_1.entity.Course;
import com.smartTech.crud_example_1.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Courses")
public class CourseController {
  @Autowired
  private CourseService courseService;

  @PostMapping("/add")
  public ResponseEntity<Course> createCourse(@RequestBody Course course){
    Course newCourse = courseService.createCourseService(course);
    return ResponseEntity.ok(newCourse);
  }

  @PostMapping("/addAll")
  public ResponseEntity<List<Course>> createCourseBulk(@RequestBody List<Course> courses){
    List<Course> newCourses = courseService.createCourseBulkService(courses);
    return ResponseEntity.ok(newCourses);
  }

  @PutMapping("/update")
  public ResponseEntity<Course> updateCourse(@RequestBody Course course){
    Course updatedCourse = courseService.updateCourseService(course);
    return ResponseEntity.ok(updatedCourse);
  }
  @DeleteMapping("Delete")
  public ResponseEntity<String> deleteCourse(@PathVariable int id){
    String status = courseService.deleteCourseService(id);
    return ResponseEntity.ok(status);
  }

  @GetMapping("")
  public ResponseEntity<List<Course>> getAllCourses(){
    List<Course> courses = courseService.getAllCoursesService();
    return ResponseEntity.ok(courses);
  }
}
