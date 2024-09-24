package com.example.esericizo23092024.esercizioLive.controller;


import com.example.esericizo23092024.esercizioLive.model.Product;
import com.example.esericizo23092024.esercizioLive.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping()
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editProduct(@Valid @RequestBody Product product, @PathVariable Long id) {
        Product editProduct = productService.editProduct(product, id);
        if (editProduct == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(editProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

}
