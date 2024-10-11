package com.example.MongoDBpierwsze.Controller;

import com.example.MongoDBpierwsze.Service.ProductService;
import com.example.MongoDBpierwsze.model.Products;
import com.example.MongoDBpierwsze.repository.ProductRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    

    @GetMapping("/products/all")
    public ResponseEntity<List<Products>> allProducts() {
        return new ResponseEntity<List<Products>>(productService.allProducts(), HttpStatus.OK);
    }

    @PostMapping("/products/add")
    public Products addProduct(@RequestBody Products product){
        return productService.addProduct(product);
    }

    @GetMapping("/product/{id}")
    public Optional<Products> productsById(@PathVariable String id){
        return productService.productsById(id);
    }

    @PutMapping("/products/update/{id}")
    public Products updateCar(@RequestBody Products product, @PathVariable String id){
        return productService.updateCar(product, id);
    }

    @DeleteMapping("/products/delete/{id}")
    public void deleteCar(@PathVariable String id){
        productService.deleteCar(id);
    }

//    @GetMapping("/products/")
//    public List<Products> productsByText(@RequestParam String text){
//        return productRepository.findByText(text);
//    }

}
