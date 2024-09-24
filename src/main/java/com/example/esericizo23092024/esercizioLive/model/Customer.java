package com.example.esericizo23092024.esercizioLive.model;

import com.example.esericizo23092024.esercizioLive.DTO.OrderDTO;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String email;
    private List<OrderDTO> orderList;

    public Customer(Long id, String name, String email, List<OrderDTO> orderList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.orderList = new ArrayList<>();
    }

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<OrderDTO> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderDTO> orderList) {
        this.orderList = orderList;
    }
}
