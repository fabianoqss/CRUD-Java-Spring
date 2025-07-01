package com.example.fabiano.project.CRUD.dto;


import com.example.fabiano.project.CRUD.entities.Produto;
import com.example.fabiano.project.CRUD.enums.TipoProduto;

import java.util.Optional;


public class ProdutoDTO {

    private Long id;
    private String descricao;
    private TipoProduto tipoProduto;
    private Double valorFornecedor;
    private Integer quantidadeEstoque;

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.descricao = produto.getDescricao();
        this.tipoProduto = produto.getTipoProduto();
        this.valorFornecedor = produto.getValorFornecedor();
        this.quantidadeEstoque = produto.getQuantidadeEstoque();
    }


    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public Double getValorFornecedor() {
        return valorFornecedor;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
}
