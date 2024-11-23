package com.smartTech.crud_example_1.service;

import com.smartTech.crud_example_1.entity.Order;
import com.smartTech.crud_example_1.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
  @Autowired
  private OrderRepository orderRepository;

  public List<Order> getAllOrders(){
    return orderRepository.findAll();
  }

  public Order saveOrder(Order order){
    return orderRepository.save(order);
  }

  public List<Order> saveOrder(List<Order> orders){
    return orderRepository.saveAll(orders);
  }

  public Order updateOrder(Order order){
    Order existingOrder = orderRepository.findById(order.getId()).orElse(null);

    existingOrder.setCustomerName(order.getCustomerName());
    existingOrder.setOrderNumber(order.getOrderNumber());
    existingOrder.setProductId(order.getProductId());

    return orderRepository.save(existingOrder);
  }

  public String deleteOrder(int id){
    orderRepository.deleteById(id);
    return "Deleted " + id;
  }

  public List<Object> getOrdersByOrderNumber(int orderNumber){
    return orderRepository.getOrdersByOrderNumber(orderNumber);
  }

  @Transactional
  public String updateOrderQuery(Order order) {
    Order existingOrder = orderRepository.findById(order.getId()).orElse(null);

    existingOrder.setCustomerName(order.getCustomerName());
    existingOrder.setOrderNumber(order.getOrderNumber());
    existingOrder.setProductId(order.getProductId());

    orderRepository.updateOrder(existingOrder.getId(),existingOrder.getCustomerName(),existingOrder.getProductId(),existingOrder.getOrderNumber());
    return "Updated " + existingOrder.getId();
  }
}
