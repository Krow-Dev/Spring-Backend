package com.yyhomemart.backend.repository;



import com.yyhomemart.backend.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
