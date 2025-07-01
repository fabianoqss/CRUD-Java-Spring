package com.example.fabiano.project.CRUD.services;

import com.example.fabiano.project.CRUD.dto.ProdutoDTO;
import com.example.fabiano.project.CRUD.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private CrudRepository crudRepository;

    @Transactional(readOnly = true)
    public ProdutoDTO findById(Long id){
        
    }

}
