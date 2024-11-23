package com.smartTech.crud_example_1.entity.Test2;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Transactional
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Passport")
public class Passport {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String passportNo;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "employee_id")
  private Employee employee;
}
