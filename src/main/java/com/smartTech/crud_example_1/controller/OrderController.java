package com.smartTech.crud_example_1.controller;

import com.smartTech.crud_example_1.entity.Order;
import com.smartTech.crud_example_1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
  @Autowired
  OrderService orderService;

  @GetMapping("")
  public ResponseEntity<List<Order>> getAllOrders(){
    List<Order> orders = orderService.getAllOrders();
    return ResponseEntity.ok(orders);
  }

  @GetMapping("/{orderNumber}")
  public ResponseEntity<List<Object>> getOrdersByOrderNumber(@PathVariable int orderNumber){
    List<Object> orders = orderService.getOrdersByOrderNumber(orderNumber);
    return ResponseEntity.ok(orders);
  }

  @PostMapping("/save")
  public ResponseEntity<Order> saveOrder(@RequestBody Order order){
    Order order1 = orderService.saveOrder(order);
    return ResponseEntity.ok(order1);
  }

  @PostMapping("/saveAll")
  public ResponseEntity<List<Order>> saveOrder(@RequestBody List<Order> orders){
    List<Order> order1 = orderService.saveOrder(orders);
    return ResponseEntity.ok(order1);
  }

  @PutMapping("/update")
  public ResponseEntity<Order> updateOrder(@RequestBody Order order){
    Order order1 = orderService.updateOrder(order);
    return ResponseEntity.ok(order1);
  }

  @PutMapping("/updateQry")
  public ResponseEntity<String> updateOrderQuery(@RequestBody Order order){
    String order1 = orderService.updateOrderQuery(order);
    return ResponseEntity.ok(order1);
  }


  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deleteOrder(@PathVariable int id){
    String order1 = orderService.deleteOrder(id);
    return ResponseEntity.ok(order1);
  }

}
