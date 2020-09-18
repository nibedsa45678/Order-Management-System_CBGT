package com.nsahoo.repository;

import com.nsahoo.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderItemRepository extends JpaRepository<OrderItem,String> {
    Optional<OrderItem> findById(String productCode);
}
