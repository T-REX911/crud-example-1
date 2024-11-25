package com.smartTech.crud_example_1.service;

import com.smartTech.crud_example_1.entity.Course;
import com.smartTech.crud_example_1.entity.Student;
import com.smartTech.crud_example_1.repository.CourseRepository;
import com.smartTech.crud_example_1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
  @Autowired
  private StudentRepository studentRepository;
  @Autowired
  private CourseRepository courseRepository;

  public Student createStudentService(Student student) {
    return studentRepository.save(student);
  }

  public Student updateStudentService(Student student) {
    Student existingStudent = studentRepository.findById(student.getId()).orElse(null);

    existingStudent.setName(student.getName());
    existingStudent.setEmail(student.getEmail());

    return studentRepository.save(existingStudent);
  }

  public String deleteStudentService(int id) {
    studentRepository.deleteById(id);
    return "Student ID :" +id + " Deleted.";
  }

  public List<Student> getAllStudentsService() {
    return studentRepository.findAll();
  }

  public Student assignCourseToStudentService(int studentId, int courseId) {
    List<Course> courseList = new ArrayList<>();
    Course course = courseRepository.findById(courseId).orElse(null);
    courseList.add(course);

    Student student = studentRepository.findById(studentId).orElse(null);
    student.setCourses(courseList);

    return studentRepository.save(student);
  }

  public List<Student> createStudentBulkService(List<Student> students) {
    return studentRepository.saveAll(students);
  }
}
