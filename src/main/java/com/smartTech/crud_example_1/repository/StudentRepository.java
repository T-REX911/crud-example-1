package com.smartTech.crud_example_1.repository;

import com.smartTech.crud_example_1.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
