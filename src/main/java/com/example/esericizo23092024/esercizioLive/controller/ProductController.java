package com.example.esericizo23092024.esercizioLive.controller;


import com.example.esericizo23092024.esercizioLive.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
@RestController
@RequestMapping("/products")
public class ProductController {
	Map <Long, Product> productMap = new HashMap <>();
	AtomicLong productId = new AtomicLong();

	@PostMapping()
	public ResponseEntity<?> addProduct( @RequestBody Product product ){
		product.setId(productId.incrementAndGet());
		productMap.put(product.getId(), product);
		return ResponseEntity.ok(product);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editProduct(@RequestBody Product product, @PathVariable Long id){
		if(productMap.containsKey(id)){
			Product newProduct = Product.builder().name(product.getName()).price(product.getPrice()).description(product.getDescription()).id(id).build();
			productMap.put(id, newProduct);
			return ResponseEntity.ok(newProduct);
		}else{
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id){
		productMap.remove(id);
		return ResponseEntity.ok(true);
	}

    /*
    elimina prodotto
     */
}
