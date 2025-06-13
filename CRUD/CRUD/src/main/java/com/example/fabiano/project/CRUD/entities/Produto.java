package com.example.fabiano.project.CRUD.entities;


import com.example.fabiano.project.CRUD.enums.TipoProduto;
import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private TipoProduto tipoProduto;
    private Double valorFornecedor;
    private Integer quantidadeEstoque;



    public Produto() {
    }

    public Produto(String descricao, TipoProduto tipoProduto, Double valorFornecedor, Integer quantidadeEstoque) {
        this.descricao = descricao;
        this.tipoProduto = tipoProduto;
        this.valorFornecedor = valorFornecedor;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public Double getValorFornecedor() {
        return valorFornecedor;
    }

    public void setValorFornecedor(Double valorFornecedor) {
        this.valorFornecedor = valorFornecedor;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
}
