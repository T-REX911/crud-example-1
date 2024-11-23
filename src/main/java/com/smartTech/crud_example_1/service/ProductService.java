package com.smartTech.crud_example_1.service;

import com.smartTech.crud_example_1.entity.Test1.Product;
import com.smartTech.crud_example_1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public Product saveProduct(Product product){
    return productRepository.save(product);
  }

  public List<Product> saveProducts(List<Product> products){
    return productRepository.saveAll(products);
  }

  public List<Product> getProducts(){
    return productRepository.findAll();
  }

  public Product getProductById(int id){
    return productRepository.findById(id).orElse(null);
  }

  public Product getProductByName(String name){
    return productRepository.findByName(name);
  }

  public String deleteProduct(int id){
    try{
      productRepository.deleteById(id);
      return id + " Deleted";
    }catch(Exception e){
      return e.toString();
    }
  }

  public Product updateProduct(Product product){
    Product existingProduct = productRepository.findById(product.getId()).orElse(null);
    existingProduct.setName(product.getName());
    existingProduct.setQty(product.getQty());
    existingProduct.setPrice(product.getPrice());
    return productRepository.save(existingProduct);
  }

  public Page<Product> getProductsPagination(int pageNumber, int pageSize) {
    Sort sort = Sort.by(Sort.Direction.ASC,"name");
    Pageable pageable = PageRequest.of(pageNumber,pageSize,sort);
    return productRepository.findAll(pageable);
  }

  public List<Product> findAllProductsQueryService(){
    return productRepository.findAllProductsQuery();
  }
}
