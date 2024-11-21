package com.smartTech.crud_example_1.repository;

import com.smartTech.crud_example_1.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
