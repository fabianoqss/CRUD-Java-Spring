package com.example.fabiano.project.CRUD.dto;

import com.example.fabiano.project.CRUD.enums.TipoProduto;

public record ProdutoDTO(
        Long id,
        String name,
        TipoProduto tipoProduto,
        Double valorFornecedor,
        Integer quantidadeEstoque
        ) {
}
