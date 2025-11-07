package com.example.fabiano.project.CRUD.entities;


import com.example.fabiano.project.CRUD.dto.MovimentoEstoqueDTO;
import com.example.fabiano.project.CRUD.enums.TipoMovimentacao;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_movimentoEstoque")
public class MovimentoEstoque {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipoMovimentacao;
    private Double valorVenda;
    private LocalDate dataVenda;

    private Integer quantidadeMovimentada;

    @ManyToMany
    @JoinTable(name = "produto_movimento_estoque",
            joinColumns = @JoinColumn(name = "movimento_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtos = new ArrayList<>();

    public MovimentoEstoque() {
    }

    public MovimentoEstoque(Long id, TipoMovimentacao tipoMovimentacao, Double valorVenda, LocalDate dataVenda, Integer quantidadeMovimentada) {
        this.id = id;
        this.tipoMovimentacao = tipoMovimentacao;
        this.valorVenda = valorVenda;
        this.dataVenda = dataVenda;
        this.quantidadeMovimentada = quantidadeMovimentada;
    }

    public MovimentoEstoque(MovimentoEstoqueDTO dto) {
        id = dto.id();
        tipoMovimentacao = dto.tipoMovimentacao();
        valorVenda = dto.valorVenda();
        dataVenda = dto.dataVenda();
        quantidadeMovimentada = dto.quantidadeMovimentada();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
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

    public List<Produto> getProdutos() {
        return produtos;
    }

}
