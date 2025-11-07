package com.example.fabiano.project.CRUD.entities;


import com.example.fabiano.project.CRUD.enums.TipoProduto;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_product")
public class Produto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    @Enumerated(EnumType.STRING)
    private TipoProduto tipoProduto;
    private Double valorFornercedor;
    private Integer QuantidadeEstoque;

    @ManyToMany(mappedBy = "produtos")
    private List<MovimentoEstoque> movimentos = new ArrayList<>();

    public Produto() {
    }

    public Produto(Long id, String descricao, TipoProduto tipoProduto, Double valorFornercedor, Integer quantidadeEstoque) {
        this.id = id;
        this.descricao = descricao;
        this.tipoProduto = tipoProduto;
        this.valorFornercedor = valorFornercedor;
        QuantidadeEstoque = quantidadeEstoque;
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

    public Double getValorFornercedor() {
        return valorFornercedor;
    }

    public void setValorFornercedor(Double valorFornercedor) {
        this.valorFornercedor = valorFornercedor;
    }

    public Integer getQuantidadeEstoque() {
        return QuantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        QuantidadeEstoque = quantidadeEstoque;
    }

    public List<MovimentoEstoque> getMovimentos() {
        return movimentos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
