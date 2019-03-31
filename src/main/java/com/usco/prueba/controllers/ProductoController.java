package com.usco.prueba.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.prueba.models.Producto;
import com.usco.prueba.repositories.ProductoRepository;

@RestController
@RequestMapping("/api/v1/producto")
public class ProductoController {

	@Autowired
	@Qualifier("prodcuto_repository")
	private ProductoRepository productoRepository;
	
	@GetMapping("/listar")
	public List<Producto> listarProductos() {
		return productoRepository.findAll();
	}
}
