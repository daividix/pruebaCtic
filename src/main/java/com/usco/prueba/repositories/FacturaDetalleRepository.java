package com.usco.prueba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usco.prueba.models.DetalleFactura;

@Repository("factura_detalle_repository")
public interface FacturaDetalleRepository extends JpaRepository<DetalleFactura, Integer>{

}
