package com.alexmoleiro.productProvider.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/products/1")
public class ProductController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getProduct() {
        return "{\"name\":\"iphoneX\"}";
    }
}
