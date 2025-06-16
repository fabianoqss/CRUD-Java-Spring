package com.example.fabiano.project.CRUD.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Table(name = "tb_itemMovimento")
public class ItemMovimento {

    @ManyToMany
    private Produto produtos;



}
