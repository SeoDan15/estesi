package com.tienda.tienda.services;

import java.util.ArrayList;

import com.tienda.tienda.entity.Producto;

public interface IntProductosService {
    public ArrayList<Producto> obtenerProductos();
    //Ambas operaciones guardar/editar
    public void guardar(Producto producto);
    public void eliminar(Integer idProducto);
    public Producto buscarPorId(Integer idProducto);
    public int totalProductos();
}
