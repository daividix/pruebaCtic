package com.usco.prueba.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.usco.prueba.models.Factura;
import com.usco.prueba.repositories.FacturaRepository;

@Service("factura_service")
public class FacturaService {

	@Autowired
	@Qualifier("factura_repository")
	public FacturaRepository facturaRepository;
	
	public Factura crearFactura(Factura factura) {
		return facturaRepository.save(factura);
	}
	
	public Optional<Factura> buscarPorId(Integer id) {
		return facturaRepository.findById(id);
	}
	
	public List<Factura> listar() {
		
		return facturaRepository.findAll();
	}
}
