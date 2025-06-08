package com.example.elasticdata.service;

import com.example.elasticdata.model.Product;
import com.example.elasticdata.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //取得メソッド
    public Optional<Product> getProductById(String id){
        return productRepository.findById(id);
    }

    //登録メソッド
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }


}
