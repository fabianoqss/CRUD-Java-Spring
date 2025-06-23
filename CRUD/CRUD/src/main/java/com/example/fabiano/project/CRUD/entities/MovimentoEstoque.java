package com.example.fabiano.project.CRUD.entities;


import com.example.fabiano.project.CRUD.enums.TipoMovimentacao;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_movimento_estoque")
public class MovimentoEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double valorVenda;
    private LocalDate dataVenda;
    private Integer quantidadeMovimentada;
    private TipoMovimentacao tipoMovimentacao;

    @OneToMany(mappedBy = "id.movimentoEstoque", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ItemMovimento> itens = new HashSet<>();

    public MovimentoEstoque() {
    }

    public MovimentoEstoque(Long id, Double valorVenda, LocalDate dataVenda, Integer quantidadeMovimentada, TipoMovimentacao tipoMovimentacao) {
        this.id = id;
        this.valorVenda = valorVenda;
        this.dataVenda = dataVenda;
        this.quantidadeMovimentada = quantidadeMovimentada;
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
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

}
