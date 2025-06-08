package com.example.elasticdata.controller;

import com.example.elasticdata.model.Product;
import com.example.elasticdata.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable String id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product saveProduct = productService.saveProduct(product);
        return ResponseEntity.ok(saveProduct);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id,@RequestBody Product product){
        Product updatedProduct = productService.updateProduct(id,product);
        return updatedProduct != null ? ResponseEntity.ok(updatedProduct) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }


}
