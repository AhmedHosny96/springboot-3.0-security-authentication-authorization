package com.hosny.service;


import com.hosny.model.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {

    List<Product> products = null;


    @PostConstruct
    public void loadProducts() {
        products = IntStream.rangeClosed(1, 100)
                .mapToObj(
                        i -> Product.builder()
                                .id(i)
                                .name("product" + i)
                                .quantity(new Random().nextInt(10))
                                .price(new Random().nextInt(5000))
                                .build()
                ).collect(Collectors.toList());
    }


    public List<Product> getProducts() {
        return products;
    }


    public Product getProduct(int id) {
        return products.stream().filter(product -> product.getId() == id)
                .findAny()
                .orElseThrow(() -> new RuntimeException("products " + id + " not found"));
    }
}
