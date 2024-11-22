package com.smartTech.crud_example_1.service;

import com.smartTech.crud_example_1.entity.Department;
import com.smartTech.crud_example_1.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
  @Autowired
  private DepartmentRepository departmentRepository;

  public Department saveDepartmentService(Department department) {
    return departmentRepository.save(department);
  }
}
