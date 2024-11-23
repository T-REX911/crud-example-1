package com.smartTech.crud_example_1.entity.Test1;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Transactional
@Table(name = "Department")
public class DepartmentTbl{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;

  /*
  //@OneToMany(mappedBy = "department")
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "department_id",referencedColumnName = "id")
  private List<Employee> employees;
  */

}
