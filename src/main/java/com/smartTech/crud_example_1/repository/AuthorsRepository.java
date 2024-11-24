package com.smartTech.crud_example_1.repository;

import com.smartTech.crud_example_1.entity.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorsRepository extends JpaRepository<Authors,Integer> {
  Authors findByName(String name);
}
