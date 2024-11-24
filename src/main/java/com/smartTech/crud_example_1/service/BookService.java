package com.smartTech.crud_example_1.service;

import com.smartTech.crud_example_1.DTO.BookDTO;
import com.smartTech.crud_example_1.entity.Authors;
import com.smartTech.crud_example_1.entity.Book;
import com.smartTech.crud_example_1.repository.AuthorsRepository;
import com.smartTech.crud_example_1.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
  @Autowired
  private BookRepository bookRepository;
  @Autowired
  private AuthorsRepository authorsRepository;

  public List<Book> getAllBooksService() {
    return bookRepository.findAll();
  }

  public Book addBookService(BookDTO bookDTO) {
    Authors authors = authorsRepository.findById(bookDTO.getAuthor_id()).orElse(null);

    Book newBook = new Book();
    newBook.setName(bookDTO.getName());
    newBook.setAuthors(authors);

    return bookRepository.save(newBook);
  }

  public Book updateBookService(BookDTO bookDTO) {
    Book existingBook = bookRepository.findById(bookDTO.getId()).orElse(null);
    Authors authors = authorsRepository.findById(bookDTO.getAuthor_id()).orElse(null);

    existingBook.setName(bookDTO.getName());
    existingBook.setAuthors(authors);

    return bookRepository.save(existingBook);
  }

  public String deleteBookService(int id) {
    bookRepository.deleteById(id);
    return "Book ID :" +id + " Deleted.";
  }
}
