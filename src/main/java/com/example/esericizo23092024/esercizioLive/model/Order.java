package com.example.esericizo23092024.esercizioLive.model;

import com.example.esericizo23092024.esercizioLive.DTO.CustomerDTO;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Order {
    private Long id;
    private CustomerDTO customer;
    @NotNull
    private List<Product> productsList;
    private Integer quantity;
    private OrderStatusEnum orderStatus;
    private LocalDateTime orderDate;


    public Order(Long id, CustomerDTO customer, List<Product> productsList, Integer quantity, OrderStatusEnum orderStatus, LocalDateTime orderDate) {
        this.id = id;
        this.customer = customer;
        this.productsList = productsList;
        this.quantity = quantity;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
    }

    public Order() {
        this.orderDate = LocalDateTime.now();
        this.productsList = new ArrayList<>();
        this.orderStatus = OrderStatusEnum.CREATED;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
