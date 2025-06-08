package com.example.elasticdata.repository;

import com.example.elasticdata.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {
}
