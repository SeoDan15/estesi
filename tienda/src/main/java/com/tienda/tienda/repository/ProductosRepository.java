package com.tienda.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.tienda.entity.Producto;

public interface ProductosRepository extends JpaRepository <Producto,Integer>{

}
