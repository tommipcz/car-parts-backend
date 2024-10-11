package com.example.MongoDBpierwsze.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {

    @Id
    private String id;
    private String title;
    private String make;
    private String model;
    private String description;
    private int price;
    private String currency;
    private String[] images;
}
