package com.smartTech.crud_example_1.service;

import com.smartTech.crud_example_1.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {
  @Autowired
  private EnrollmentRepository enrollmentRepository;
}
