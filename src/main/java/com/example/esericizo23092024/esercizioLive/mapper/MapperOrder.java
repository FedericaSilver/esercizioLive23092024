package com.example.esericizo23092024.esercizioLive.mapper;

import com.example.esericizo23092024.esercizioLive.DTO.CustomerDTO;
import com.example.esericizo23092024.esercizioLive.DTO.OrderDTO;
import com.example.esericizo23092024.esercizioLive.model.Order;

public class MapperOrder {

    public static OrderDTO toDTO(Order order) {
        if (order == null) {
            return null;
        }
        return new OrderDTO(order.getId(), order.getProductsList(), order.getQuantity(), order.getOrderStatus(), order.getOrderDate());
    }

    public static Order toOrder(OrderDTO orderDTO) {
        if (orderDTO == null) {
            return null;
        }
        return new Order(orderDTO.getId(), new CustomerDTO(), orderDTO.getProductsList(), orderDTO.getQuantity(), orderDTO.getOrderStatus(), orderDTO.getOrderDate());
    }
}


