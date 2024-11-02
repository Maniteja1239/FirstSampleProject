package com.example.firstsample.exceptions;


import lombok.Getter;

@Getter
public class ProductNotFoundException extends Exception{
    private Long id;
    public ProductNotFoundException(Long id,String message){
        super(message);
        this.id=id;
    }
}
