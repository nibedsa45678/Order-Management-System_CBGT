package com.nsahoo.controller;

import com.nsahoo.dto.OrderItemDto;
import com.nsahoo.entity.OrderItem;
import com.nsahoo.exception.ProductDoestNotExist;
import com.nsahoo.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/OrderItem")
public class OrderItemController {
    @Autowired
    private OrderItemService service;

    @PostMapping("/createOrderItem")
    public ResponseEntity createOrderItems(@RequestBody OrderItemDto orderItemDto) {
        OrderItem orderItem = service.createOrderItems(orderItemDto);
        return ResponseEntity.ok(orderItem);
    }

    @GetMapping("/showItems")
    public List<OrderItem> showAllItems() {
        return service.showAllItems();
    }

    @GetMapping("/showItems/{productCode}")
    public ResponseEntity showItemByCode(@PathVariable String productCode) {
        OrderItem orderItem = null;
        try {
            orderItem = service.showItemByCode(productCode);
        } catch (ProductDoestNotExist e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok(orderItem);
    }

}

