package com.smartTech.crud_example_1.repository;

import com.smartTech.crud_example_1.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Integer> {
}
