package com.fakestore.service;

import com.fakestore.controller.ProductController;
import com.fakestore.model.ProductDTO;
import com.fakestore.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(ProductController.class)
public class ProductServiceTest {
    @Autowired
    private MockMvc mockMvc;  // MockMvc to simulate HTTP requests

    @Mock
    private ProductService productService;  // Mock the ProductService to avoid actual service calls

    @Test
    void testGetProductsByCategory() throws Exception {
        // Mock the service response
        when(productService.getProductsByCategory("electronics"))
                .thenReturn(List.of(new ProductDTO(1L, "Product 1", 100.0, "Electronics")));

        // Perform the HTTP request and assert the expected result
        mockMvc.perform(get("/products/category/electronics"))
                .andExpect(status().isOk())  // Verify the status code is 200 OK
                .andExpect(jsonPath("$[0].title").value("Product 1"));  // Verify the title of the first product is "Product 1"
    }

}
