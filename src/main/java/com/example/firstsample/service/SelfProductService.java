package com.example.firstsample.service;

import com.example.firstsample.exceptions.ProductNotFoundException;
import com.example.firstsample.models.Product;
import com.example.firstsample.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;

    SelfProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product updateProductById(Long id, Product product) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProductById(Long id) {

    }


}
