package com.smartTech.crud_example_1.controller;

import com.smartTech.crud_example_1.entity.Product;
import com.smartTech.crud_example_1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avi/v1")
public class ProductController {
  @Autowired
  private ProductService productService;

  @PostMapping("/addProduct")
  public Product addProduct(@RequestBody Product product){
    return productService.saveProduct(product);
  }

  @PostMapping("/addProducts")
  public List<Product> addProducts(@RequestBody List<Product> products){
    return productService.saveProducts(products);
  }

  @GetMapping("/products")
  public List<Product> findAllProducts(){
    return productService.getProducts();
  }

  @GetMapping("/productsList")
  public ResponseEntity<List<Product>> findAllProductsNew(){
    List<Product> products = productService.getProducts();
    return ResponseEntity.ok(products);
  }

  @GetMapping("/products/{pageNumber}/{pageSize}")
  public ResponseEntity<Page<Product>> findAllProducts(@PathVariable int pageNumber,@PathVariable int pageSize){

    Page<Product> products = productService.getProductsPagination(pageNumber,pageSize);
    return ResponseEntity.ok(products);
  }

  @GetMapping("/productById/{id}")
  public Product findProductById(@PathVariable int id){
    return productService.getProductById(id);
  }

  @GetMapping("/productByName/{name}")
  public Product findProductByName(@PathVariable String name){
    return productService.getProductByName(name);
  }

  @PutMapping("/updateProduct")
  public Product updateProduct(@RequestBody Product product){
    return productService.updateProduct(product);
  }

  @DeleteMapping("/product/{id}")
  public String deleteProductById(@PathVariable int id){
    return productService.deleteProduct(id);
  }
}
