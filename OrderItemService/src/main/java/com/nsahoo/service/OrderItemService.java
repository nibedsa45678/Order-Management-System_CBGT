package com.nsahoo.service;

import com.nsahoo.dto.OrderItemDto;
import com.nsahoo.entity.OrderItem;
import com.nsahoo.exception.ProductDoestNotExist;
import com.nsahoo.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository repository;

    public OrderItem createOrderItems(OrderItemDto orderItemDto) {
        OrderItem orderItem = new OrderItem();
        orderItem.setProductCode(orderItemDto.getProductCode());
        orderItem.setProductName(orderItemDto.getProductName());
        orderItem.setQuantity(orderItemDto.getQuantity());
        return repository.save(orderItem);
    }

    public List<OrderItem> showAllItems() {
        return (List<OrderItem>) repository.findAll();
    }


    public OrderItem showItemByCode(String productCode) throws ProductDoestNotExist {

        Optional<OrderItem> optionalOrder = repository.findById(productCode);
        return optionalOrder.orElseThrow(() -> new ProductDoestNotExist("Couldn't find a Product with given ProductCode: " + productCode));
    }
}
