package com.fakestore.controller;

import com.fakestore.exception.ApiException;
import com.fakestore.exception.ResourceNotFoundException;
import com.fakestore.model.ProductDTO;
import com.fakestore.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/category/{category}")
    public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable String category) throws ResourceNotFoundException {
        return ResponseEntity.ok(productService.getProductsByCategory(category));
    }

    @PostMapping
    public ResponseEntity<ProductDTO> addProduct(@RequestBody @Valid ProductDTO product) throws ApiException {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(product));
    }
}
