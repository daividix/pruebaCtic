package com.usco.prueba.controllers;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.prueba.models.DetalleFactura;
import com.usco.prueba.models.Factura;
import com.usco.prueba.models.Producto;
import com.usco.prueba.repositories.FacturaDetalleRepository;
import com.usco.prueba.request.FormFactura;
import com.usco.prueba.response.Response;
import com.usco.prueba.services.FacturaService;

@RestController
@RequestMapping("/api/v1/factura")
public class FacturaController {

	@Autowired
	@Qualifier("factura_service")
	private FacturaService facturaService;

	@Autowired
	@Qualifier("factura_detalle_repository")
	private FacturaDetalleRepository facturaDetalleRepository;
	
	@PostMapping("/crearFactura")
	public Response crearFactura(@RequestBody FormFactura formFactura) {
		System.out.println(formFactura.toString());
		Factura factura = new Factura(new Date(), formFactura.getCliente());
		Set<DetalleFactura> detallesFactura = new HashSet<>();
		formFactura.getDetalleFactura().forEach(detalle -> {
			Producto producto = detalle.getProducto();
			int precio = detalle.getCantidad()*producto.getPrecio();
			detalle.setPrecio(precio);
			DetalleFactura newDetalleFactura = facturaDetalleRepository.save(detalle);
			if (newDetalleFactura != null) {
				detallesFactura.add(newDetalleFactura);
			}
		});
		factura.setDetalleFactura(detallesFactura);
		
		Factura newFactura = facturaService.crearFactura(factura);
		
		if (newFactura != null) {
			Response response = new Response(true, "Factura creada");
			response.setResult(newFactura);
			return response;
		}else {
			Response response = new Response(false, "Hubo un problema al crear la factura");
			return response;
		}
		
	}
	
	@GetMapping("/buscarPorId/{id}")
	public Response buscarFacturaPorId(@PathVariable("id") Integer id) {
		Optional<Factura> factura = facturaService.buscarPorId(id);
		if (factura != null) {
			Response response = new Response(true, "Se ha encontrado la factura");
			return response;
		}else {
			Response response = new Response(false, "Hubo un problema en la busqueda");
			return response;
		}
	}
	
	@GetMapping("/listar")
	public Response listarFacturas() {
		try {
			List<Factura> facturas = facturaService.listar();
			if(facturas != null) {
				System.out.println("fffffffffffffffffffffffffffffffffffffffffffffffffff"+facturas.toString());
				Response response = new Response(true, "Se han encontrado las facturas");
				response.setResult(facturas);
				return response;
			}else {
				Response response = new Response(false, "Hubo un problema en la busqueda");
				return response;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			Response response = new Response(false, "Hubo un problema en la busqueda");
			response.setError(e.toString());
			return response;
		}
		
		
	}
}
