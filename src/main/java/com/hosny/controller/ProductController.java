package com.hosny.controller;


import com.hosny.model.Product;
import com.hosny.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {


    private final ProductService productService;

    @GetMapping("/test")
    public String test() {
        return "test....";
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")

    public Product getProduct(@PathVariable("id") int id) {
        return productService.getProduct(id);
    }
}
