package com.example.esericizo23092024.esercizioLive.DTO;

import com.example.esericizo23092024.esercizioLive.model.OrderStatusEnum;
import com.example.esericizo23092024.esercizioLive.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {
    private Long id;
    @Builder.Default
    private List<Product> productsList = new ArrayList<>();
    private Integer quantity;
    private OrderStatusEnum orderStatus;
    private LocalDateTime orderDate;


}
