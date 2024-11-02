package com.example.firstsample.exceptionHandler;

import com.example.firstsample.DTO.ExceptionHandlerDTO;
import com.example.firstsample.DTO.ProductNotFoundExceptionHandlerDTO;
import com.example.firstsample.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionHandlerDTO> handleArithmeticException(){
        ExceptionHandlerDTO exceptionHandlerDTO=new ExceptionHandlerDTO();
        exceptionHandlerDTO.setMessage("Arithmetic Exception");
        exceptionHandlerDTO.setResolution("Please revise ur Maths lectures");
        ResponseEntity<ExceptionHandlerDTO> responseEntity=new ResponseEntity<>(exceptionHandlerDTO,HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionHandlerDTO> handleProductNotFoundException(ProductNotFoundException exception){
        ProductNotFoundExceptionHandlerDTO productNotFoundExceptionHandlerDTO=new ProductNotFoundExceptionHandlerDTO();
        //productNotFoundExceptionHandlerDTO.setId();
        productNotFoundExceptionHandlerDTO.setMessage("Product with "+exception.getId()+" is not found");
        ResponseEntity<ProductNotFoundExceptionHandlerDTO> responseEntity=new ResponseEntity<>(productNotFoundExceptionHandlerDTO,HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public void handleArrayIndexOutOfBoundsException(){

    }

    @ExceptionHandler(NullPointerException.class)
    public void handleNullPointerException(){

    }
}
