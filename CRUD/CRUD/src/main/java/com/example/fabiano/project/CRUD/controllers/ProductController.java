package com.example.fabiano.project.CRUD.controllers;

import com.example.fabiano.project.CRUD.dto.ProdutoDTO;
import com.example.fabiano.project.CRUD.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produtos")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> findByID(@PathVariable Long id){
        ProdutoDTO dto = productService.findByID(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ProdutoDTO>> findAll(Pageable pageable){
        Page<ProdutoDTO> dto = productService.findAll(pageable);
        return ResponseEntity.ok().body(dto);
    }

    
}
