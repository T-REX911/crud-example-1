package com.smartTech.crud_example_1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Order")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private int orderNumber;
  private String customerName;
  private int productId;
}
