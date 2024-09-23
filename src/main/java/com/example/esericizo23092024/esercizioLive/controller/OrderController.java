package com.example.esericizo23092024.esercizioLive.controller;

import com.example.esericizo23092024.esercizioLive.model.Customer;
import com.example.esericizo23092024.esercizioLive.model.Order;
import com.example.esericizo23092024.esercizioLive.model.OrderStatusEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    Map<Long, Order> orderMap = new HashMap<>();

   /* @PostMapping("/create-order")
    public ResponseEntity<?> createNewOrder(){

    }*/

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateStatus( @RequestBody String newStatus, @PathVariable Long id ){
        if( orderMap.containsKey(id) ) {
            Order order = orderMap.get(id);
           order.setOrderStatus(OrderStatusEnum.valueOf(newStatus.toUpperCase()));
            return ResponseEntity.ok(order);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No order with id " + id);
        }
    }
    /*
    crea nuovo ordine che avrà cutstomer_id nella chiamata, lista prodotti e quantità

    aggiorna stato ordine id e stato

    ottiene tutti gli ordini ( cliente ) customer_id e data

    ottiene tutti i prodotti ( data )
     */
}
