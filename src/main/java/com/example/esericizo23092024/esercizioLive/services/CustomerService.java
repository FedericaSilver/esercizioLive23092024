package com.example.esericizo23092024.esercizioLive.services;

import com.example.esericizo23092024.esercizioLive.model.Customer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CustomerService {

    Map<Long, Customer> customerMap = new HashMap<>();
    AtomicLong customerId = new AtomicLong();

    public Customer createNewCustomer(Customer customer) {
        customer.setId(customerId.incrementAndGet());
        customerMap.put(customer.getId(), customer);
        return customer;
    }

    public Customer changeCustomerName(Long id, String name) {
        Customer customer;
        if (customerMap.containsKey(id)) {
            customer = customerMap.get(id);
            customer.setName(name);
            return customer;
        }
        return null;
    }

    public void deleteCustomer(Long id) {
        customerMap.remove(id);
    }
}
