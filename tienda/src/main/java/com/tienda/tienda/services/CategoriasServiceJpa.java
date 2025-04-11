package com.tienda.tienda.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.tienda.entity.Categoria;
import com.tienda.tienda.repository.CategoriasRepository;

@Service
public class CategoriasServiceJpa implements IntCategoriasService {

    @Autowired
	private CategoriasRepository repoCategorias;

	@Override
	public ArrayList<Categoria> obtenerCategorias() {
		// Devuelve todas las categorías desde el repositorio
		return (ArrayList<Categoria>) repoCategorias.findAll();
	}

	@Override
	public void guardar(Categoria categoria) {
		repoCategorias.save(categoria);
	}

	@Override
	public void eliminar(Integer idCategoria) {
		repoCategorias.deleteById(idCategoria);
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {		
		Optional<Categoria> optional = repoCategorias.findById(idCategoria);
		if (optional.isPresent()){
			return optional.get();
		}
		return null;
	}

	@Override
	public int totalCategorias() {
		// Retorna el número total de categorías
		return (int) repoCategorias.count();
	}
}
