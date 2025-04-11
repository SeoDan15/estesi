package com.tienda.tienda.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tienda.tienda.entity.Categoria;
import com.tienda.tienda.entity.Producto;
import com.tienda.tienda.services.IntCategoriasService;
import com.tienda.tienda.services.IntProductosService;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    private IntProductosService serviceProductos;
	
	@Autowired
	private IntCategoriasService serviceCategorias;
	
	@GetMapping("/nueva")
	public String nueva(Model model) {
		ArrayList<Categoria> categorias = serviceCategorias.obtenerCategorias();
		model.addAttribute("categorias", categorias);
		model.addAttribute("producto", new Producto()); 
		return "productos/formProductos";
	}
	
	@PostMapping("/guardar")
	public String guardar(Producto producto) {
		serviceProductos.guardar(producto);
		return "redirect:/productos/index";
	}
	

    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        ArrayList<Producto> productos = serviceProductos.obtenerProductos();
        // System.out.println(productos);
        model.addAttribute("productos", productos);
        return "productos/ListaProductos";
	}

    @GetMapping("/eliminar")
	public String getMethodName(@RequestParam ("id") Integer idProducto) {
		// // System.out.println("Id: " + idProducto);
		serviceProductos.eliminar(idProducto);
		return "redirect:/productos/index";
	}

    @GetMapping("/detalles")
	public String detalle(@RequestParam("id") Integer idProducto,
		Model model){
		Producto producto = serviceProductos.buscarPorId(idProducto);
		model.addAttribute("producto", producto);
		return "productos/detalles";
	}
}
