package com.smartTech.crud_example_1.service;

import com.smartTech.crud_example_1.entity.Course;
import com.smartTech.crud_example_1.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
  @Autowired
  private CourseRepository courseRepository;

  public Course createCourseService(Course course) {
    return courseRepository.save(course);
  }

  public Course updateCourseService(Course course) {
    Course existingCourse = courseRepository.findById(course.getId()).orElse(null);

    existingCourse.setName(course.getName());
    existingCourse.setDescription(course.getDescription());

    return courseRepository.save(existingCourse);
  }

  public String deleteCourseService(int id) {
    courseRepository.deleteById(id);
    return "Course ID :" +id + " Deleted.";
  }

  public List<Course> getAllCoursesService() {
    return courseRepository.findAll();
  }

  public List<Course> createCourseBulkService(List<Course> courses) {
    return  courseRepository.saveAll(courses);
  }
}
