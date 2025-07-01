package com.example.fabiano.project.CRUD.repository;

import com.example.fabiano.project.CRUD.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudRepository extends JpaRepository<Produto, Long> {
}
