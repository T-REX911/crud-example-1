package com.smartTech.crud_example_1.repository;

import com.smartTech.crud_example_1.entity.Test1.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    @Query("select o from Order o where o.orderNumber = :orderNumber")
    //@Query("select o,p from Order o inner join Product p on o.productId = p.id where o.orderNumber = :orderNumber")
    List<Object> getOrdersByOrderNumber(@Param("orderNumber") int orderNumber);


    @Modifying
    @Query("update Order set customerName = :customerName, productId = :productId, orderNumber = :orderNumber where id = :id")
    void updateOrder(@Param("id") int id,
                      @Param("customerName") String customerName,
                      @Param("productId") int productId,
                      @Param("orderNumber") int orderNumber);
}
