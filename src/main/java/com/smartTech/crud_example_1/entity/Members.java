package com.smartTech.crud_example_1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "Members")
public class Members {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "Borrow_Records",
      joinColumns = @JoinColumn(name = "member_id"),
      inverseJoinColumns = @JoinColumn(name = "book_id"))
  @JsonIgnore
  @JsonManagedReference
  private List<Book> bookList = new ArrayList<>();;

  @JsonIgnore
  @OneToOne(mappedBy = "members")
  private BorrowRecords borrowRecords;

}
