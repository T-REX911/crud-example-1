package com.smartTech.crud_example_1.controller;

import com.smartTech.crud_example_1.entity.Test2.Department;
import com.smartTech.crud_example_1.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
  @Autowired
  private DepartmentService departmentService;
  @PostMapping("/save")
  public ResponseEntity<Department> saveDepartment(@RequestBody Department department){
    Department department1 = departmentService.saveDepartmentService(department);

    return ResponseEntity.ok(department1);
  }
}
