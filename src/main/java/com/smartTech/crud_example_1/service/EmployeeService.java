package com.smartTech.crud_example_1.service;

import com.smartTech.crud_example_1.DTO.EmployeeDTO;
import com.smartTech.crud_example_1.entity.Test2.Address;
import com.smartTech.crud_example_1.entity.Test2.Department;
import com.smartTech.crud_example_1.entity.Test2.Employee;
import com.smartTech.crud_example_1.entity.Test2.Passport;
import com.smartTech.crud_example_1.repository.AddressRepository;
import com.smartTech.crud_example_1.repository.DepartmentRepository;
import com.smartTech.crud_example_1.repository.EmployeeRepository;
import com.smartTech.crud_example_1.repository.PassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    Employee employee = new Employee();
    employee.setName(employeeDTO.getName());
    employee.setAddress(address);
    employee.setPassport(passport);
    employee.setDepartment(department);

    return employeeRepository.save(employee);
  }
}
