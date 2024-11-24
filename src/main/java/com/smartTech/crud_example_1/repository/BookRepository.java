package com.smartTech.crud_example_1.repository;

import com.smartTech.crud_example_1.entity.Authors;
import com.smartTech.crud_example_1.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

  List<Book> findAllByAuthors(Authors authors);
  @Query("select b from Book b where b.authors.id = :author_id")
  List<Book> findAllByAuthors(@Param("author_id") int id);
}
