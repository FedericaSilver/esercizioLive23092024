package com.example.esericizo23092024.esercizioLive.controller;

import com.example.esericizo23092024.esercizioLive.model.Order;
import com.example.esericizo23092024.esercizioLive.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/orders")
public class OrderController {

    Map<Long, Order> orderMap = new HashMap<>();
    AtomicLong orderId = new AtomicLong();

    @Autowired
    CustomerController customerController;

    @Autowired
    OrderService orderService;

    @PostMapping("/create-order/{id}")
    public ResponseEntity<?> createNewOrder(@PathVariable("id") Long id, @Valid @RequestBody List<Long> productList) {
        orderService.createNewOrder(id, productList);
        return ResponseEntity.ok(orderService.createNewOrder(id, productList));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateStatus(@RequestBody String newStatus, @PathVariable Long id) {
        Order order = orderService.updateStatus(newStatus, id);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(order);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getAllOrders(@PathVariable("id") Long id, @RequestBody String date) {
        List<Order> allOrders = orderService.getAllOrders(id, date);
        if (allOrders == null) {
            return ResponseEntity.notFound().build();
        } else return ResponseEntity.ok(allOrders);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<?> orderByProductAndDate(@PathVariable("id") Long id, @RequestBody String localDateTime) {
        List<Order> filtredOrders = orderService.orderByProductAndDate(id, localDateTime);
        if (filtredOrders == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(filtredOrders);
    }
}
