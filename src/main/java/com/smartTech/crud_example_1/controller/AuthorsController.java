package com.smartTech.crud_example_1.controller;

import com.smartTech.crud_example_1.DTO.AuthorBooksDTO;
import com.smartTech.crud_example_1.entity.Authors;
import com.smartTech.crud_example_1.service.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Authors")
public class AuthorsController {
  @Autowired
  private AuthorsService authorsService;
  @GetMapping("")
  public ResponseEntity<List<Authors>> getAllAuthors(){
    List<Authors> authorsList = authorsService.getAllAuthorsService();
    return ResponseEntity.ok(authorsList);
  }
  @PostMapping("/add")
  public ResponseEntity<Authors> addAuthor(@RequestBody Authors authors){
    Authors newAuthors = authorsService.addAuthorService(authors);
    return ResponseEntity.ok(newAuthors);
  }
  @PutMapping("/update")
  public ResponseEntity<Authors> updateAuthor(@RequestBody Authors authors){
    Authors updatedAuthor = authorsService.updateAuthorService(authors);
    return ResponseEntity.ok(updatedAuthor);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deleteAuthor(@PathVariable int id){
    return ResponseEntity.ok(authorsService.deleteAuthorService(id));
  }

  @GetMapping("/name/{name}")
  public ResponseEntity<AuthorBooksDTO> getAllBooksByAuthor(@PathVariable String name){
    AuthorBooksDTO authorBooksDTO = authorsService.getAllBooksByAuthorService(name);
    return ResponseEntity.ok(authorBooksDTO);
  }
}
