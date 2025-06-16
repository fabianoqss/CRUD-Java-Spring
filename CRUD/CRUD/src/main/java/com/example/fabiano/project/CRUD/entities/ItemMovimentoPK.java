package com.example.fabiano.project.CRUD.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ItemMovimentoPK {

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "movimento_id")
    private MovimentoEstoque movimentoEstoque;

    public ItemMovimentoPK() {
    }

    public ItemMovimentoPK(Produto produto, MovimentoEstoque movimentoEstoque) {
        this.produto = produto;
        this.movimentoEstoque = movimentoEstoque;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public MovimentoEstoque getMovimentoEstoque() {
        return movimentoEstoque;
    }

    public void setMovimentoEstoque(MovimentoEstoque movimentoEstoque) {
        this.movimentoEstoque = movimentoEstoque;
    }
}
