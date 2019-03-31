package com.usco.prueba.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usco.prueba.models.Factura;

@Repository("factura_repository")
public interface FacturaRepository extends JpaRepository<Factura, Integer>{

	public abstract Optional<Factura> findById(Integer id);
}
