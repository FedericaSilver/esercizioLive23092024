package com.example.esericizo23092024.esercizioLive.services;

import com.example.esericizo23092024.esercizioLive.DTO.OrderDTO;
import com.example.esericizo23092024.esercizioLive.mapper.MapperCustomer;
import com.example.esericizo23092024.esercizioLive.mapper.MapperOrder;
import com.example.esericizo23092024.esercizioLive.model.Customer;
import com.example.esericizo23092024.esercizioLive.model.Order;
import com.example.esericizo23092024.esercizioLive.model.OrderStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class OrderService {
    @Autowired
    CustomerService customerService;
    @Autowired
    ProductService productService;

    Map<Long, Order> orderMap = new HashMap<>();
    AtomicLong orderId = new AtomicLong();


    public Order createNewOrder(Long id, List<Long> productId) {
        //CustomerService
        Optional<Customer> customerFound = customerService.getCustomerMap().values().stream().filter(c -> c.getId().equals(id)).findFirst();
        Order order = new Order();
        if (productId.isEmpty()) {
            return null; //eccezione
        } else {
            //ProductService
            productId.stream()
                    .map(productService.productMap::get)
                    .filter(Objects::nonNull)
                    .forEach(order.getProductsList()::add);
            if (customerFound.isPresent()) {
                order.setId(orderId.incrementAndGet());
                order.setQuantity(order.getProductsList().size());
                order.setCustomer(MapperCustomer.toDTO(customerFound.get()));
                orderMap.put(order.getId(), order);
                List<OrderDTO> customerOrder = customerFound.get().getOrderList();
                if (customerOrder == null) {
                    customerOrder = new ArrayList<>();
                }
                customerOrder.add(MapperOrder.toDTO(order));
                customerFound.get().setOrderList(customerOrder);
            }
            return order;
        }
    }

    public Order updateStatus(String newStatus, Long id) {
        if (orderMap.containsKey(id)) {
            Order order = orderMap.get(id);
            order.setOrderStatus(OrderStatusEnum.valueOf(newStatus.toUpperCase()));
            return order;
        }
        return null;
    }

    public List<Order> getAllOrders(Long id, String date) {
        boolean clientFound = orderMap.values().stream().anyMatch(c -> c.getId().equals(id));
        if (!clientFound) {
            return null;
        }
        return orderMap.values().stream().filter(c -> c.getId().equals(id) && c.getOrderDate().truncatedTo(ChronoUnit.MINUTES)
                .equals(LocalDateTime.parse(date))).toList();
    }

    public List<Order> orderByProductAndDate(Long id, String localDateTime) {
        List<Order> filtredOrders = orderMap.values().stream().filter(o -> o.getOrderDate().truncatedTo(ChronoUnit.MINUTES).equals(LocalDateTime.parse(localDateTime)) && o.getId().equals(id)).toList();
        if (filtredOrders.isEmpty()) {
            return null;
        }
        return filtredOrders;
    }
}
