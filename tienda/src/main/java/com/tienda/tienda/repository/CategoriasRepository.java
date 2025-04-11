package com.tienda.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.tienda.entity.Categoria;

public interface CategoriasRepository extends JpaRepository <Categoria,Integer> {
    
}
