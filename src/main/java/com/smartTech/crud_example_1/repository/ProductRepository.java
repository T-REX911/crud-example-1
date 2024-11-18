package com.smartTech.crud_example_1.repository;

import com.smartTech.crud_example_1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


  Product findByName(String name);
}
