package com.fakestore.service;

import com.fakestore.exception.ApiException;
import com.fakestore.exception.ResourceNotFoundException;
import com.fakestore.model.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private static final String BASE_URL = "https://fakestoreapi.com";
    private final RestTemplate restTemplate;

    @Autowired
    public ProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Cacheable(value = "productsByCategory", key = "#category")
    public List<ProductDTO> getProductsByCategory(String category) throws ResourceNotFoundException {
        String url = BASE_URL + "/products/category/" + category;
        try {
            ResponseEntity<ProductDTO[]> response = restTemplate.getForEntity(url, ProductDTO[].class);
            return Arrays.asList(Objects.requireNonNull(response.getBody()));
        } catch (HttpClientErrorException e) {
            throw new ResourceNotFoundException("Category not found: " + category);
        }
    }

    public ProductDTO addProduct(ProductDTO product) throws ApiException {
        String url = BASE_URL + "/products";
        try {
            ResponseEntity<ProductDTO> response = restTemplate.postForEntity(url, product, ProductDTO.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            throw new ApiException("Failed to add product: " + e.getMessage());
        }
    }
}
