package com.example.esericizo23092024.esercizioLive.services;

import com.example.esericizo23092024.esercizioLive.model.Product;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Getter
public class ProductService {

    Map<Long, Product> productMap = new HashMap<>();
    AtomicLong productId = new AtomicLong();

    public Product addProduct(Product product) {
        product.setId(productId.incrementAndGet());
        productMap.put(product.getId(), product);
        return product;
    }

    public Product editProduct(Product product, Long id) {
        if (productMap.containsKey(id)) {
            Product newProduct = Product.builder().name(product.getName()).price(product.getPrice()).description(product.getDescription()).id(id).build();
            productMap.put(id, newProduct);
            return newProduct;
        }
        return null;

    }

    public void deleteProduct(Long id) {
        productMap.remove(id);
    }

}
