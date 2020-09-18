package com.nsahoo.dto;

import java.io.Serializable;

public class OrderItemDto implements Serializable {
    private String productCode;
    private String productName;
    private Integer quantity;

    public String getProductCode() {
        return productCode;
    }

    public OrderItemDto setProductCode(String productCode) {
        this.productCode = productCode;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public OrderItemDto setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public OrderItemDto setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
}
