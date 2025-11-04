package com.example.fabiano.project.CRUD.services;


import com.example.fabiano.project.CRUD.dto.ProdutoDTO;
import com.example.fabiano.project.CRUD.entities.Produto;
import com.example.fabiano.project.CRUD.repository.ProductRepository;
import com.example.fabiano.project.CRUD.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProdutoDTO findByID(Long id){
        Produto result = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não Encontrado"));
        return new ProdutoDTO(result);
    }



    @Transactional(readOnly = true)
    public Page<ProdutoDTO> findAll(Pageable pageable){
        try {
            Page<Produto> result = productRepository.findAll(pageable);
            return result.map(x -> new ProdutoDTO(x));
        }catch (Exception e){
            throw new ResourceNotFoundException("Lista de Produtos nao encontrada" + e);
        }
    }

    

}
