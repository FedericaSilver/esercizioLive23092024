package com.example.esericizo23092024.esercizioLive.controller;

import com.example.esericizo23092024.esercizioLive.model.Customer;
import com.example.esericizo23092024.esercizioLive.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping()
    public ResponseEntity<Customer> createNewCustomer(@Valid @RequestBody Customer customer) {
        customerService.createNewCustomer(customer);
        return ResponseEntity.ok(customer);
    }

    @PatchMapping("/customer-name/{id}")
    public ResponseEntity<?> changeCustomerName(@PathVariable("id") Long id, @RequestParam("name") String name) {
        Customer customer = customerService.changeCustomerName(id, name);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok(true);
    }

}
