package com.example.firstsample.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Category {
    private long id;
    private String description;
}
