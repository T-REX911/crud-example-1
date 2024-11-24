package com.smartTech.crud_example_1.controller;

import com.smartTech.crud_example_1.DTO.BookDTO;
import com.smartTech.crud_example_1.entity.Book;
import com.smartTech.crud_example_1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Books")
public class BookController {
  @Autowired
  private BookService bookService;

  @GetMapping("")
  public ResponseEntity<List<Book>> getAllBooks(){
    List<Book> bookList = bookService.getAllBooksService();
    return ResponseEntity.ok(bookList);
  }
  @PostMapping("/add")
  public ResponseEntity<Book> addBook(@RequestBody BookDTO bookDTO){
    Book newBook = bookService.addBookService(bookDTO);
    return ResponseEntity.ok(newBook);
  }
  @PutMapping("/update")
  public ResponseEntity<Book> updateBook(@RequestBody BookDTO bookDTO){
    Book updatedBook = bookService.updateBookService(bookDTO);
    return ResponseEntity.ok(updatedBook);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deleteBook(@PathVariable int id){
    return ResponseEntity.ok(bookService.deleteBookService(id));
  }
}
