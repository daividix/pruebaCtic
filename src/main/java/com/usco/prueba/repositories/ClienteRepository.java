package com.usco.prueba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usco.prueba.models.Cliente;

@Repository("cliente_repository")
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
