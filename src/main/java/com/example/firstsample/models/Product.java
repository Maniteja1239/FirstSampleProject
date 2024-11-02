package com.example.firstsample.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Product {
    private long id;
    private String title;
    private Double price;
    private String image;
    private Category category;
}