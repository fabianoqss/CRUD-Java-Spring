package com.example.fabiano.project.CRUD.controllers;

import com.example.fabiano.project.CRUD.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produtos")
public class ProductController {

    @Autowired
    private ProductService productService;

}
