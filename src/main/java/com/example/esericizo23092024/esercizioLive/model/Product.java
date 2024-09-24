package com.example.esericizo23092024.esercizioLive.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    private Long id;
    @NotNull
    private String name;
    private String description;
    @NotNull
    private BigDecimal price;
}
