package com.example.fabiano.project.CRUD.dto;

import com.example.fabiano.project.CRUD.enums.TipoMovimentacao;

import java.time.LocalDate;

public record MovimentoEstoqueDTO(
        Long id,
        TipoMovimentacao tipoMovimentacao,
        Double valorVenda,
        LocalDate dataVenda,
        Integer quantidadeMovimentada
                                  ) {
}
