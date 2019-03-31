package com.usco.prueba.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.prueba.models.Cliente;
import com.usco.prueba.repositories.ClienteRepository;
import com.usco.prueba.response.Response;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

	@Autowired
	@Qualifier("cliente_repository")
	private ClienteRepository clienteRepository;
	
	@GetMapping("/listar")
	public List<Cliente> listarClientes() {
		return clienteRepository.findAll();
	}
}
