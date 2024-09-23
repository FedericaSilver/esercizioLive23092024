package com.example.esericizo23092024.esercizioLive.model;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
}
