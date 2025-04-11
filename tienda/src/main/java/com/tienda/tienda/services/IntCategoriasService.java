package com.tienda.tienda.services;

import java.util.ArrayList;

import com.tienda.tienda.entity.Categoria;


public interface IntCategoriasService {
    public ArrayList<Categoria> obtenerCategorias();
    //Ambas operaciones guardar/editar
    public void guardar(Categoria categoria);
    public void eliminar(Integer idCategoria);
    public Categoria buscarPorId(Integer idCategoria);
    public int totalCategorias();

}

