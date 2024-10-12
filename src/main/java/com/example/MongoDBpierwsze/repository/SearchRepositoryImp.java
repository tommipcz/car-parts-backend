package com.example.MongoDBpierwsze.repository;

import com.example.MongoDBpierwsze.model.Products;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import com.mongodb.client.AggregateIterable;

import com.mongodb.client.MongoCollection;


import org.bson.Document;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImp implements SearchReprsitory{

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<Products> findByText(String text) {

        final List<Products> products = new ArrayList<>();

        MongoDatabase database = client.getDatabase("car-parts");
        MongoCollection<Document> collection = database.getCollection("products");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                                new Document("query", text)
                                        .append("path", Arrays.asList("title", "model")))),
                new Document("$sort",
                        new Document("exp", 1L))));
//                new Document("$limit", 5L)));

        result.forEach(doc -> products.add(converter.read(Products.class,doc)));

        return products;
    }
}
