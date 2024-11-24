package com.smartTech.crud_example_1.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Transactional
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Book")
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "author_id")
  @JsonBackReference
  @JsonIgnore
  private Authors authors;

  @ManyToMany(mappedBy = "bookList")
  @JsonBackReference
  @JsonIgnore
  private List<Members> membersList = new ArrayList<>();

}

//Books, Authors, Members, Borrow Records