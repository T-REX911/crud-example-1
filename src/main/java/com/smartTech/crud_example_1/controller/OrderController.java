package com.smartTech.crud_example_1.controller;

import com.smartTech.crud_example_1.entity.Order;
import com.smartTech.crud_example_1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
  @Autowired
  OrderService orderService;

  @GetMapping("/Orders")
  public ResponseEntity<List<Order>> getAllOrders(){

    List<Order> orders = orderService.getAllOrders();

    return ResponseEntity.ok(orders);
  }
}
