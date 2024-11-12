package com.example.firstsample.controllers;

import com.example.firstsample.exceptions.ProductNotFoundException;
import com.example.firstsample.models.Product;
import com.example.firstsample.service.FakeStoreProductService;
import com.example.firstsample.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("selfProductService") ProductService productService){
        this.productService=productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id) throws ProductNotFoundException {
        //int a=1/0;
        Product product=productService.getProductById(id);
        ResponseEntity<Product> responseEntity;

        responseEntity=new ResponseEntity<>(product,HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PutMapping("/{id}")
    public Product updateProductById(@PathVariable("id") Long id,@RequestBody Product product){
        return productService.updateProductById(id,product);
    }

}
