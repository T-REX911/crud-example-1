package com.smartTech.crud_example_1.service;

import com.smartTech.crud_example_1.DTO.AuthorBooksDTO;
import com.smartTech.crud_example_1.entity.Authors;
import com.smartTech.crud_example_1.entity.Book;
import com.smartTech.crud_example_1.repository.AuthorsRepository;
import com.smartTech.crud_example_1.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorsService {
  @Autowired
  private AuthorsRepository authorsRepository;
  @Autowired
  private BookRepository bookRepository;

  public List<Authors> getAllAuthorsService() {
    return authorsRepository.findAll();
  }

  public Authors addAuthorService(Authors authors) {
    return authorsRepository.save(authors);
  }

  public Authors updateAuthorService(Authors authors) {
    Authors existingAuthor = authorsRepository.findById(authors.getId()).orElse(null);
    existingAuthor.setName(authors.getName());
    return authorsRepository.save(existingAuthor);
  }

  public String deleteAuthorService(int id) {
    authorsRepository.deleteById(id);
    return "Author ID :" +id + " Deleted.";
  }

  public AuthorBooksDTO getAllBooksByAuthorService(String name) {
    Authors authors = authorsRepository.findByName(name);
    //List<Book> bookList = bookRepository.findAllByAuthors(authors);
    List<Book> bookList = bookRepository.findAllByAuthors(authors.getId());

    AuthorBooksDTO authorBooksDTO = new AuthorBooksDTO();
    authorBooksDTO.setId(authors.getId());
    authorBooksDTO.setName(authors.getName());
    authorBooksDTO.setBookList(bookList);

    return authorBooksDTO;
  }
}
