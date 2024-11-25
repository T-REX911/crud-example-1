package com.smartTech.crud_example_1.repository;

import com.smartTech.crud_example_1.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {
}
