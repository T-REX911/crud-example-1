package com.smartTech.crud_example_1.entity;

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
@Table(name = "Enrollment")
public class Enrollment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String enrollmentDate;
  private int grade;
}
