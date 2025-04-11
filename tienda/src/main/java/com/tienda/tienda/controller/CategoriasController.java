package com.tienda.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tienda.tienda.entity.Categoria;
import com.tienda.tienda.services.IntCategoriasService;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {

    
	@Autowired
	private IntCategoriasService serviceCategorias;

	@GetMapping("/consultar")
	public String consultar(@RequestParam("id") Integer idCategoria,
		Model model){
		Categoria categoria = serviceCategorias.buscarPorId(idCategoria);
		model.addAttribute("categoria", categoria);
		return "categorias/formCategoria";
	}

    

	@PostMapping("/guardar")
	public String guardar(Categoria categoria){
		// System.out.println(categoria);
		serviceCategorias.guardar(categoria);
		return "redirect:/categorias/index";
	}

	@GetMapping("/nueva")
	public String nuevaCategoria(Categoria categoria){
		return "categorias/formCategoria";
	}

	@GetMapping("/eliminar")
	public String getMethodName(@RequestParam ("id") Integer idCategoria) {
		// System.out.println(idCategoria);
		serviceCategorias.eliminar(idCategoria);
		return "redirect:/categorias/index";
	}
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		model.addAttribute("categorias", serviceCategorias.obtenerCategorias());
		model.addAttribute("total", serviceCategorias.totalCategorias());
		return "categorias/ListaCategorias";
	}
	
}

