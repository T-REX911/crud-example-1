package com.smartTech.crud_example_1.service;

import com.smartTech.crud_example_1.DTO.EmployeeDTO;
import com.smartTech.crud_example_1.entity.*;
import com.smartTech.crud_example_1.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
  @Autowired
  private EmployeeRepository employeeRepository;
  @Autowired
  private AddressRepository addressRepository;
  @Autowired
  private PassportRepository passportRepository;
  @Autowired
  private DepartmentRepository departmentRepository;
  @Autowired
  private ProjectRepository projectRepository;

  public List<Employee> saveEmployees(List<Employee> employees) {
    return employeeRepository.saveAll(employees);
  }

  public List<Employee> getAllEmployeesService() {
    return employeeRepository.findAll();
  }


  public Employee getEmployeeByIdService(int id) {
    return employeeRepository.findById(id).orElse(null);
  }

  public Employee saveEmployee(EmployeeDTO employeeDTO) {
    Address address = addressRepository.findById(employeeDTO.getAddress_id()).orElse(null);
    Passport passport = passportRepository.findById(employeeDTO.getPassport_id()).orElse(null);
    Department department = departmentRepository.findById(employeeDTO.getDepartment_id()).orElse(null);

    List<Project> projects = new ArrayList<>();
    Project project = projectRepository.findById(employeeDTO.getProject_id()).orElse(null);
    projects.add(project);

    Employee employee = new Employee();
    employee.setName(employeeDTO.getName());
    employee.setAddress(address);
    employee.setPassport(passport);
    employee.setDepartment(department);
    employee.setProjects(projects);
    return employeeRepository.save(employee);

  }
}
