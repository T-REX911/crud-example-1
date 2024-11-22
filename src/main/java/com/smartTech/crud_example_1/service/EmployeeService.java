package com.smartTech.crud_example_1.service;

import com.smartTech.crud_example_1.entity.Employee;
import com.smartTech.crud_example_1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> saveEmployees(List<Employee> employees){
        return employeeRepository.saveAll(employees);
    }


  public List<Employee> getAllEmployeesService() {
    return employeeRepository.findAll();
  }

  public Employee saveEmployee(Employee employee) {
      return employeeRepository.save(employee);
  }
}
