package com.example.firstsample.service;


import com.example.firstsample.exceptions.ProductNotFoundException;
import com.example.firstsample.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product updateProductById(Long id,Product product);
}
