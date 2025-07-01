package com.example.fabiano.project.CRUD.services;

import com.example.fabiano.project.CRUD.dto.ProdutoDTO;
import com.example.fabiano.project.CRUD.entities.Produto;
import com.example.fabiano.project.CRUD.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository crudRepository;

    @Transactional(readOnly = true)
    public ProdutoDTO findById(Long id){
        Produto produto = crudRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("Produto Não encontrado"));
        return new ProdutoDTO(produto);
    }

    


}
