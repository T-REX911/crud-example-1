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
@Table(name = "Project")
public class Project {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
}
