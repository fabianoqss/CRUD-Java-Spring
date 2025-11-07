package com.example.fabiano.project.CRUD.repository;

import com.example.fabiano.project.CRUD.dto.MovimentoEstoqueDTO;
import com.example.fabiano.project.CRUD.entities.MovimentoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentoEstoqueRepository extends JpaRepository<MovimentoEstoque, Long> {
}
