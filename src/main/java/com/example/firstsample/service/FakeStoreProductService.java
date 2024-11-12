package com.example.firstsample.service;

import com.example.firstsample.DTO.FakeStoreProductDTO;
import com.example.firstsample.exceptions.ProductNotFoundException;
import com.example.firstsample.models.Category;
import com.example.firstsample.models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    public Product convertFakeStoreProductToProduct(FakeStoreProductDTO dto){
        Product product=new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setImage(dto.getImage());
        Category category=new Category();
        category.setDescription(dto.getDescription());
        product.setCategory(category);
        return product;
    }
    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        FakeStoreProductDTO fakeStoreProductDTO=restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDTO.class);
        if(fakeStoreProductDTO==null){
            throw new ProductNotFoundException(id,"Given id is invalid");
        }
        //restTemplate.put()
        return convertFakeStoreProductToProduct(fakeStoreProductDTO);
    }


    @Override
    public List<Product> getAllProducts() {
        //return "Got the array";
        List<Product> list=new ArrayList<Product>();
        FakeStoreProductDTO[] response=restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDTO[].class);
        //FakeStoreProductDTO[] fakeStoreProductDTO= response.getBody();
        for(FakeStoreProductDTO fd:response){
            Product product=convertFakeStoreProductToProduct(fd);
            list.add(product);
        }
        return list;
    }

    @Override
    public Product updateProductById(Long id, Product product) {
        FakeStoreProductDTO fakeStoreProductDTO=new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(product.getTitle());
        fakeStoreProductDTO.setPrice(product.getPrice());
        fakeStoreProductDTO.setImage(product.getImage());
        Category category= product.getCategory();
        fakeStoreProductDTO.setDescription(category.getDescription());
        //fakeStoreProductDTO.setCategory(product.setCategory());
        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreProductDTO, FakeStoreProductDTO.class);
        HttpMessageConverterExtractor<FakeStoreProductDTO> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDTO.class, restTemplate.getMessageConverters());
        FakeStoreProductDTO response= restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT, requestCallback, responseExtractor);
        return convertFakeStoreProductToProduct(response);
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProductById(Long id) {

    }
}
