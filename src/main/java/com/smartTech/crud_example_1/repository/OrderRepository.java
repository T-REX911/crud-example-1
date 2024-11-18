package com.smartTech.crud_example_1.repository;

import com.smartTech.crud_example_1.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    //@Query("select o from Order o where o.orderNumber = :orderNumber")
    @Query("select o,p from Order o inner join Product p on o.productId = p.id where o.orderNumber = :orderNumber")
    List<Object> getOrdersByOrderNumber(@Param("orderNumber") int orderNumber);
}
