package com.smartTech.crud_example_1.entity.Test2;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Transactional
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Employee")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;

  //OneToOne UniDirection
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "address_id")
  private Address address;

  //OneToOne BiDirection
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "passport_id")
  private Passport passport;

  //OneToMany
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "department_id")
  private Department department;

}
