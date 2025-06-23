package com.example.fabiano.project.CRUD.entities;

import jakarta.persistence.*;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        ItemMovimentoPK that = (ItemMovimentoPK) o;
        return Objects.equals(produto, that.produto) && Objects.equals(movimentoEstoque, that.movimentoEstoque);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(produto);
        result = 31 * result + Objects.hashCode(movimentoEstoque);
        return result;
    }
}
