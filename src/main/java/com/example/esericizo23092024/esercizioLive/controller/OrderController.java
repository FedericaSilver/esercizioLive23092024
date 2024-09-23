package com.example.esericizo23092024.esercizioLive.controller;

import com.example.esericizo23092024.esercizioLive.model.Customer;
import com.example.esericizo23092024.esercizioLive.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    Map<Integer, Order> orderMap = new HashMap<>();

    @PostMapping("/create-order")
    public ResponseEntity<?> createNewOrder(){

    }
    /*
    crea nuovo ordine
    aggiorna stato ordine
    ottiene tutti gli ordini ( cliente )
    ottiene tutti i prodotti ( data )
     */
}
