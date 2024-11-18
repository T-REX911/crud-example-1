package com.smartTech.crud_example_1.controller;

import com.smartTech.crud_example_1.entity.Order;
import com.smartTech.crud_example_1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
  @Autowired
  OrderService orderService;

  @GetMapping("/orders")
  public ResponseEntity<List<Order>> getAllOrders(){
    List<Order> orders = orderService.getAllOrders();
    return ResponseEntity.ok(orders);
  }

  @GetMapping("/orders/{orderNumber}")
  public ResponseEntity<List<Object>> getOrdersByOrderNumber(@PathVariable int orderNumber){
    List<Object> orders = orderService.getOrdersByOrderNumber(orderNumber);
    return ResponseEntity.ok(orders);
  }

  @PostMapping("/order/save")
  public ResponseEntity<Order> saveOrder(@RequestBody Order order){
    Order order1 = orderService.saveOrder(order);
    return ResponseEntity.ok(order1);
  }

  @PutMapping("/order/update")
  public ResponseEntity<Order> updateOrder(@RequestBody Order order){
    Order order1 = orderService.updateOrder(order);
    return ResponseEntity.ok(order1);
  }

  @DeleteMapping("/order/delete/{id}")
  public ResponseEntity<String> deleteOrder(@PathVariable int id){
    String order1 = orderService.deleteOrder(id);
    return ResponseEntity.ok(order1);
  }

}
