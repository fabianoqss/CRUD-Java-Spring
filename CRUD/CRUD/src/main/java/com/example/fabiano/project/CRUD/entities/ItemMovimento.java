package com.example.fabiano.project.CRUD.entities;


import com.example.fabiano.project.CRUD.enums.TipoMovimentacao;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "tb_produto_movimento")
public class ItemMovimento {

        @EmbeddedId
        private ItemMovimentoPK id = new ItemMovimentoPK();

        private Integer quantidadeMovimentada;
        private TipoMovimentacao tipoMovimentacao;
        private LocalDate dataVenda;
        private Double valorVenda;

    public ItemMovimento() {
    }

    public ItemMovimento(Produto produto, MovimentoEstoque movimentoEstoque, Integer quantidadeMovimentada, TipoMovimentacao tipoMovimentacao, LocalDate dataVenda, Double valorVenda) {
        id.setProduto(produto);
        id.setMovimentoEstoque(movimentoEstoque);
        this.quantidadeMovimentada = quantidadeMovimentada;
        this.tipoMovimentacao = tipoMovimentacao;
        this.dataVenda = dataVenda;
        this.valorVenda = valorVenda;
    }

    public Produto getProduto(){
        return id.getProduto();
    }

    public MovimentoEstoque getMovimentoEstoque(){
        return id.getMovimentoEstoque();
    }

    public void setProduto(Produto produto){
        id.setProduto(produto);
    }

    public void setMovimentoEstoque(MovimentoEstoque movimentoEstoque){
        id.setMovimentoEstoque(movimentoEstoque);
    }

    public Integer getQuantidadeMovimentada() {
        return quantidadeMovimentada;
    }

    public void setQuantidadeMovimentada(Integer quantidadeMovimentada) {
        this.quantidadeMovimentada = quantidadeMovimentada;
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }
}
