package com.tienda.tienda.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.tienda.entity.Producto;
import com.tienda.tienda.repository.ProductosRepository;

@Service
public class ProductosServiceJpa implements IntProductosService {

    @Autowired
    private ProductosRepository repoProductos;

    @Override
    public ArrayList<Producto> obtenerProductos() {
        // TODO Auto-generated method stub
        return (ArrayList<Producto>) repoProductos.findAll();
    }
    

    @Override
    public void guardar(Producto producto) {
        // TODO Auto-generated method stub
        repoProductos.save(producto);
    }

    @Override
    public void eliminar(Integer idProducto) {
        repoProductos.deleteById(idProducto);
    }

    @Override
	public Producto buscarPorId(Integer idProducto) {		
		Optional<Producto> optional = repoProductos.findById(idProducto);
		if (optional.isPresent()){
			return optional.get();
		}
		return null;
	}

    @Override
    public int totalProductos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'totalProductos'");
    }

}
