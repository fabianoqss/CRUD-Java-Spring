package com.example.fabiano.project.CRUD.dto;

import com.example.fabiano.project.CRUD.entities.Produto;
import com.example.fabiano.project.CRUD.enums.TipoProduto;

import java.util.Optional;

public record ProdutoDTO(
        Long id,
        String descricao,
        TipoProduto tipoProduto,
        Double valorFornecedor,
        Integer quantidadeEstoque
        ) {

    public ProdutoDTO(Produto produto){
        this(produto.getId(),
                produto.getDescricao(),
                produto.getTipoProduto(),
                produto.getValorFornercedor(),
                produto.getQuantidadeEstoque()
        );
    }

}
