package com.smartTech.crud_example_1.repository;

import com.smartTech.crud_example_1.entity.Test1.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


  Product findByName(String name);

  @Query("select p from Product p")
  List<Product> findAllProductsQuery();
}
