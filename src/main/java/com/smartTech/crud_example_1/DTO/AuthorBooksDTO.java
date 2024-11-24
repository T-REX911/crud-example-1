package com.smartTech.crud_example_1.DTO;

import com.smartTech.crud_example_1.entity.Book;
import lombok.Data;

import java.util.List;

@Data
public class AuthorBooksDTO {

  private int id;
  private String name;
  private List<Book> bookList;
}
