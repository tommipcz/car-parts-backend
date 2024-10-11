package com.example.MongoDBpierwsze.repository;

import com.example.MongoDBpierwsze.model.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Products, String> {

}
