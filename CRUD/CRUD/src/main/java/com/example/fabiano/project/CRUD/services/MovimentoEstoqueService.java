package com.example.fabiano.project.CRUD.services;

import com.example.fabiano.project.CRUD.dto.MovimentoEstoqueDTO;
import com.example.fabiano.project.CRUD.entities.MovimentoEstoque;
import com.example.fabiano.project.CRUD.entities.Produto;
import com.example.fabiano.project.CRUD.repository.MovimentoEstoqueRepository;
import com.example.fabiano.project.CRUD.repository.ProductRepository;
import com.example.fabiano.project.CRUD.services.exceptions.EstoqueInsuficienteException;
import com.example.fabiano.project.CRUD.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovimentoEstoqueService {

    @Autowired
    private MovimentoEstoqueRepository movimentoEstoqueRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public void saidaEstoque(MovimentoEstoqueDTO dto){
        Produto produto = productRepository.findById(dto.id())
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));

        if(dto.quantidadeMovimentada() > produto.getQuantidadeEstoque()){
            throw new EstoqueInsuficienteException("Quantidade insuficiente em estoque.");
        }
        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - dto.quantidadeMovimentada());
        productRepository.save(produto);


    }


}
