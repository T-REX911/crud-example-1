package com.smartTech.crud_example_1.controller;

import com.smartTech.crud_example_1.entity.Employee;
import com.smartTech.crud_example_1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/saveAll")
    public ResponseEntity<List<Employee>> saveEmpoloyees(List<Employee> employees){
        List<Employee> employeeList = employeeService.saveEmployees(employees);

        return ResponseEntity.ok(employeeList);
    }
}
