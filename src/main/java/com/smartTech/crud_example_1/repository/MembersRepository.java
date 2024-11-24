package com.smartTech.crud_example_1.repository;

import com.smartTech.crud_example_1.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MembersRepository extends JpaRepository<Members, Integer> {
  @Query("SELECT m FROM Members m JOIN m.bookList b where b.id = :book_id")
  List<Members> findByBookId(@Param("book_id") int id);
}
