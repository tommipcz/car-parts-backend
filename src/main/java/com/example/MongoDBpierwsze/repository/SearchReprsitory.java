package com.example.MongoDBpierwsze.repository;

import com.example.MongoDBpierwsze.model.Products;

import java.util.List;

public interface SearchReprsitory {

    List<Products> findByText(String text);
}
