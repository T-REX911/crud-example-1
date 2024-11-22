package com.smartTech.crud_example_1.controller;

import com.smartTech.crud_example_1.entity.Employee;
import com.smartTech.crud_example_1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/saveAll")
    public ResponseEntity<List<Employee>>saveEmployees(@RequestBody List<Employee> employees){
        List<Employee> employeeList = employeeService.saveEmployees(employees);

        return ResponseEntity.ok(employeeList);
    }

    @PostMapping("/save")
    public ResponseEntity<Employee>saveEmployee(@RequestBody Employee employee){
        System.out.println(employee);
        Employee saved = employeeService.saveEmployee(employee);

        return ResponseEntity.ok(saved);
    }

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employeeList = employeeService.getAllEmployeesService();
        return ResponseEntity.ok(employeeList);
    }
}

