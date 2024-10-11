package com.example.MongoDBpierwsze.Service;

import com.example.MongoDBpierwsze.model.Products;
import com.example.MongoDBpierwsze.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Products> allProducts(){
        return productRepository.findAll();
    }

    public Products addProduct(Products product){
        return productRepository.save(product);
    }

    public Optional<Products> productsById(String id){
        return productRepository.findById(id);
    }

    public Products updateCar(Products product, String id){
        return productRepository.findById(id)
                .map(newProduct -> {
                    newProduct.setTitle(product.getTitle());
                    newProduct.setMake(product.getMake());
                    newProduct.setModel(product.getModel());
                    newProduct.setDescription(product.getDescription());
                    newProduct.setPrice(product.getPrice());
                    newProduct.setCurrency(product.getCurrency());
                    return productRepository.save(newProduct);
                }).orElseThrow(RuntimeException::new);
    }

    public void deleteCar(String id){
        productRepository.deleteById(id);
    }


//    private String title;
//    private String make;
//    private String model;
//    private String description;
//    private int price;
//    private String currency;

}
