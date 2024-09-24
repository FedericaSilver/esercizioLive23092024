package com.example.esericizo23092024.esercizioLive.mapper;

import com.example.esericizo23092024.esercizioLive.DTO.CustomerDTO;
import com.example.esericizo23092024.esercizioLive.model.Customer;

import java.util.ArrayList;

public class MapperCustomer {

    public static CustomerDTO toDTO(Customer customer) {
        if (customer == null) {
            return null;
        }
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getEmail());
    }

    public static Customer toCustomer(CustomerDTO customerDTO) {
        if (customerDTO == null) {
            return null;
        }
        return new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getEmail(), new ArrayList<>());
    }
}
